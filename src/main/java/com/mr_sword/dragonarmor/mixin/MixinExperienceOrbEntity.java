package com.mr_sword.dragonarmor.mixin;

import com.mr_sword.dragonarmor.util.MixinHooks;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public class MixinExperienceOrbEntity {

    @Inject(at = @At(value = "INVOKE", target = "net/minecraft/entity/player/PlayerEntity.sendPickup(Lnet/minecraft/entity/Entity;I)V"), method = "onPlayerCollision")
    private void colytra$onPlayerCollision(PlayerEntity playerEntity, CallbackInfo cb) {
        @SuppressWarnings("ConstantConditions") ExperienceOrbEntity orb =
                (ExperienceOrbEntity) (Object) this;
        MixinHooks.repairColytra(playerEntity, orb);
    }
}
