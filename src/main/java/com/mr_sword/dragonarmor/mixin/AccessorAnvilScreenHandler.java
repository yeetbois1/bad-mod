package com.mr_sword.dragonarmor.mixin;

import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AnvilScreenHandler.class)
public interface AccessorAnvilScreenHandler {

    @Accessor
    void setRepairItemUsage(int repairItemUsage);

    @Accessor
    Property getLevelCost();

    @Accessor
    String getNewItemName();
}
