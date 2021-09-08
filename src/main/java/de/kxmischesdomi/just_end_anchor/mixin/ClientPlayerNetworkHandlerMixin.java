package de.kxmischesdomi.just_end_anchor.mixin;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayerNetworkHandlerMixin {

	@Inject(method = "onGameStateChange", at = @At("HEAD"))
	public void onStateChange(GameStateChangeS2CPacket p, CallbackInfo ci) {

		if (p.getReason() == GameStateChangeS2CPacket.GAME_WON) {
			EndAnchorMod.respawnAfterCredits = true;
		}

	}

}
