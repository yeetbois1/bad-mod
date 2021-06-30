package com.mr_sword.dragonarmor.util;

import com.mr_sword.dragonarmor.DragonArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SkullItem;
import net.minecraft.nbt.NbtCompound;

public class DragonNbt {

    public static final String HELMET_TAG = DragonArmor.MOD_ID + ":helmetUpgrade";

    public static boolean hasUpgrade(ItemStack stack) {return stack.getSubTag(HELMET_TAG) != null;}

    public ItemStack getHelmet(ItemStack stack) {
        NbtCompound tag = stack.getSubTag(HELMET_TAG);
        return tag != null ? ItemStack.fromNbt(tag) : ItemStack.EMPTY;
    }

    public static void setHelmet(ItemStack headStack, ItemStack helmetStack) {
        headStack.getOrCreateTag().put(HELMET_TAG, helmetStack.writeNbt(new NbtCompound()));
    }

    public static void damageHelmet(LivingEntity livingEntity, ItemStack headStack, ItemStack helmetStack, int amount) {
        helmetStack.damage(amount, livingEntity, damager -> damager.sendEquipmentBreakStatus(EquipmentSlot.HEAD));

        setHelmet(headStack, helmetStack);
    }

    public static boolean isUsable(ItemStack headStack, ItemStack helmetStack) {

        if (helmetStack.isEmpty()) {
            return false;
        }

        return helmetStack.getItem() instanceof SkullItem;
    }
}
