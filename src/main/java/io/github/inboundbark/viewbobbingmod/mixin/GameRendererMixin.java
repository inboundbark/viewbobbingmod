package io.github.inboundbark.viewbobbingmod.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GameRenderer.class)
public abstract class GameRendererMixin {
    @WrapWithCondition(
        method = "method_3188", // renderWorld descriptor changed in 1.20.5, using intermediary here makes it compatible through all versions
        remap = false,
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/GameRenderer;bobView(Lnet/minecraft/client/util/math/MatrixStack;F)V",
            remap = true
        )
    )
    private boolean dontBobView(GameRenderer instance, MatrixStack matrices, float tickDelta) {
        return false; // do nothing
    }
}