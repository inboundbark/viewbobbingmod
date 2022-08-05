package com.inboundbark.noscreenshake.mixins.minecraft;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EntityRenderer.class)
public abstract class EntityRendererMixin {
    @Redirect(
            method = "setupCameraTransform",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;setupViewBobbing(F)V"))
    private void dontViewBobbing(EntityRenderer instance, float p_78475_1_) {
        // do nothing
    }
}
