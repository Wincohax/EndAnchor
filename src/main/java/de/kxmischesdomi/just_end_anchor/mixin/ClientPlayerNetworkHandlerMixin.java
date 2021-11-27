package de.kxmischesdomi.just_end_anchor.mixin;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
@Mixin(ClientPacketListener.class)
public abstract class ClientPlayerNetworkHandlerMixin {

	@Inject(method = "handleGameEvent", at = @At("HEAD"))
	public void onStateChange(ClientboundGameEventPacket p, CallbackInfo ci) {

		if (p.getEvent() == ClientboundGameEventPacket.WIN_GAME) {
			EndAnchorMod.respawnAfterCredits = true;
		}

	}

}
