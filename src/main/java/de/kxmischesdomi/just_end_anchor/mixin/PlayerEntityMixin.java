package de.kxmischesdomi.just_end_anchor.mixin;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import de.kxmischesdomi.just_end_anchor.common.blocks.EndAnchorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
@Mixin(Player.class)
public abstract class PlayerEntityMixin {

	@Inject(method = "findRespawnPositionAndUseSpawnBlock", at = @At(value = "HEAD"), cancellable = true)
	private static void findRespawn(ServerLevel world, BlockPos pos, float f, boolean bl, boolean bl2, CallbackInfoReturnable<Optional<Vec3>> cir) {
		BlockState blockState = world.getBlockState(pos);
		Block block = blockState.getBlock();

		if (EndAnchorMod.respawnAfterCredits) {
			EndAnchorMod.respawnAfterCredits = false;
			return;
		}

		if (block instanceof EndAnchorBlock && blockState.getValue(EndAnchorBlock.CHARGES) > 0 && EndAnchorBlock.isEnd(world)) {
			Optional<Vec3> optional = EndAnchorBlock.findRespawnPosition(EntityType.PLAYER, world, pos);
			if (!bl2 && optional.isPresent()) {
				world.setBlock(pos, blockState.setValue(EndAnchorBlock.CHARGES, blockState.getValue(EndAnchorBlock.CHARGES) - 1), Block.UPDATE_ALL);
			}

			cir.setReturnValue(optional);
		}
	}

}
