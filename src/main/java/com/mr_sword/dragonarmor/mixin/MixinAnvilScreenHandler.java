package com.mr_sword.dragonarmor.mixin;

import com.mr_sword.dragonarmor.util.MixinHooks;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public class MixinAnvilScreenHandler {

    @Inject(at = @At("HEAD"), method = "updateResult()V", cancellable = true)
    public void colytra$updateResult(CallbackInfo cb) {
        @SuppressWarnings("ConstantConditions") AnvilScreenHandler screenHandler = (AnvilScreenHandler) (Object) this;

        if (MixinHooks.repairColytra(screenHandler)) {
            cb.cancel();
        }
    }
}
