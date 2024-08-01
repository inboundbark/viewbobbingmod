package io.github.inboundbark.viewbobbingmod.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Redirect(
        method = "method_3188", // renderWorld descriptor changed in 1.20.5, using intermediary here makes it compatible through all versions
        remap = false,
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/GameRenderer;bobView(Lnet/minecraft/client/util/math/MatrixStack;F)V",
            remap = true
        )
    )
    private void dontBobView(GameRenderer gameRenderer, MatrixStack matrixStack, float tickDelta) {
        // do nothing
    }
}