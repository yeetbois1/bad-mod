package com.mr_sword.dragonarmor.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ExperienceOrbEntity.class)
public interface AccessorExperienceOrbEntity {

    @Accessor
    void setAmount(int amount);
}
