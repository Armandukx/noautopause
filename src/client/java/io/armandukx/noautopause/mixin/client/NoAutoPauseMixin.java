package io.armandukx.noautopause.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class NoAutoPauseMixin {
    /**
     * Prevent Minecraft from automatically pausing / opening the pause screen
     * when the window loses focus in singleplayer
     */
    @Inject(method = "onWindowFocusChanged", at = @At("HEAD"), cancellable = true)
    private void preventPauseScreen(boolean focused, CallbackInfo ci) {
        if (!focused) {
            // Debug
            System.out.println("[NoAutoPause] Preventing pause screen due to lost focus.");
            // Cancel the vanilla focus-lost pause logic
            ci.cancel();
        }
    }
}
