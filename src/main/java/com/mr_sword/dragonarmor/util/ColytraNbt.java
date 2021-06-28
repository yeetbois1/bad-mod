package com.mr_sword.dragonarmor.util;

import com.mr_sword.dragonarmor.DragonArmor;
import com.mr_sword.dragonarmor.config.ColytraConfig;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class ColytraNbt {

    public static final String ELYTRA_TAG = DragonArmor.MOD_ID + ":ElytraUpgrade";

    public static boolean hasUpgrade(ItemStack stack) {
        return stack.getSubTag(ELYTRA_TAG) != null;
    }

    public static ItemStack getElytra(ItemStack stack) {
        NbtCompound tag = stack.getSubTag(ELYTRA_TAG);
        return tag != null ? ItemStack.fromNbt(tag) : ItemStack.EMPTY;
    }

    public static void setElytra(ItemStack chestStack, ItemStack elytraStack) {
        chestStack.getOrCreateTag().put(ELYTRA_TAG, elytraStack.writeNbt(new NbtCompound()));
    }

    public static void damageElytra(LivingEntity livingEntity, ItemStack chestStack,
                                    ItemStack elytraStack, int amount) {
        ColytraConfig.ColytraMode mode = ColytraConfig.colytraMode;

        if (mode == ColytraConfig.ColytraMode.NORMAL) {
            elytraStack.damage(amount, livingEntity,
                    damager -> damager.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
        } else if (mode == ColytraConfig.ColytraMode.UNISON) {
            chestStack.damage(amount, livingEntity,
                    damager -> damager.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
        }
        setElytra(chestStack, elytraStack);
    }

    public static boolean isUseable(ItemStack chestStack, ItemStack elytraStack) {

        if (elytraStack.isEmpty()) {
            return false;
        }
        ColytraConfig.ColytraMode colytraMode = ColytraConfig.colytraMode;

        if (colytraMode == ColytraConfig.ColytraMode.NORMAL) {
            return elytraStack.getItem() instanceof ElytraItem && ElytraItem.isUsable(elytraStack);
        } else if (colytraMode == ColytraConfig.ColytraMode.UNISON) {
            return !chestStack.isDamageable() || (chestStack.getDamage() < chestStack.getMaxDamage() - 1);
        }
        return true;
    }
}
