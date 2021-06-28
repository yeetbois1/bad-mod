package com.mr_sword.dragonarmor.mixin;

import com.mr_sword.dragonarmor.util.MixinHooks;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {

    @Inject(at = @At("TAIL"), method = "tick")
    public void colytra$onTick(CallbackInfo cb) {
        @SuppressWarnings("ConstantConditions") PlayerEntity playerEntity = (PlayerEntity) (Object) this;
        MixinHooks.updateColytra(playerEntity);
    }
}
