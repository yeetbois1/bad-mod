package com.mr_sword.dragonarmor.crafting;

import com.mr_sword.dragonarmor.config.ColytraConfig;
import com.mr_sword.dragonarmor.registry.RegsiterItems;
import com.mr_sword.dragonarmor.util.ColytraNbt;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElytraAttachmentRecipe extends SpecialCraftingRecipe {

    public static final SpecialRecipeSerializer<ElytraAttachmentRecipe> CRAFTING_ATTACH_ELYTRA =
            new SpecialRecipeSerializer<>(
                    ElytraAttachmentRecipe::new);

    public ElytraAttachmentRecipe(Identifier id) {
        super(id);
    }

    private static void mergeEnchantments(ItemStack source, ItemStack destination) {
        Map<Enchantment, Integer> mapSource = EnchantmentHelper.get(source);
        Map<Enchantment, Integer> mapDestination = EnchantmentHelper.get(destination);

        for (Enchantment enchantment : mapSource.keySet()) {

            if (enchantment == null || !enchantment.isAcceptableItem(destination)) {
                continue;
            }
            int destLevel = mapDestination.getOrDefault(enchantment, 0);
            int srcLevel = mapSource.get(enchantment);
            srcLevel = destLevel == srcLevel ? srcLevel + 1 : Math.max(srcLevel, destLevel);

            for (Enchantment destEnch : mapDestination.keySet()) {

                if (enchantment != destEnch && !destEnch.canCombine(enchantment)) {
                    return;
                }
            }

            if (srcLevel > enchantment.getMaxLevel()) {
                srcLevel = enchantment.getMaxLevel();
            }
            mapDestination.put(enchantment, srcLevel);
        }
        EnchantmentHelper.set(mapDestination, destination);
        EnchantmentHelper.set(new HashMap<>(), source);
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack elytra = ItemStack.EMPTY;

        for (int i = 0; i < inv.size(); ++i) {
            ItemStack currentStack = inv.getStack(i);

            if (currentStack.isEmpty()) {
                continue;
            }

            if (isValid(currentStack)) {

                if (!itemstack.isEmpty() || ColytraNbt.hasUpgrade(currentStack)) {
                    return false;
                }
                itemstack = currentStack;
            } else {

                if (!elytra.isEmpty() || !(currentStack.getItem() instanceof ElytraItem)) {
                    return false;
                }
                elytra = currentStack;
            }
        }
        return !itemstack.isEmpty() && !elytra.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack elytra = ItemStack.EMPTY;

        for (int k = 0; k < inv.size(); ++k) {
            ItemStack currentStack = inv.getStack(k);

            if (currentStack.isEmpty()) {
                continue;
            }

            if (isValid(currentStack)) {

                if (!itemstack.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                itemstack = currentStack.copy();
                itemstack.setCount(1);
            } else {

                if (!(currentStack.getItem() instanceof ElytraItem)) {
                    return ItemStack.EMPTY;
                }
                elytra = currentStack.copy();
            }
        }

        if (!itemstack.isEmpty() && !elytra.isEmpty()) {

            if (ColytraConfig.colytraMode != ColytraConfig.ColytraMode.NORMAL) {
                mergeEnchantments(elytra, itemstack);
                itemstack.setRepairCost(elytra.getRepairCost() + itemstack.getRepairCost());
                Text name = elytra.getName();
                boolean hasCustomName = elytra.hasCustomName();
                elytra = new ItemStack(Items.ELYTRA);

                if (hasCustomName) {
                    elytra.setCustomName(name);
                }
            }
            itemstack.getOrCreateTag().put(ColytraNbt.ELYTRA_TAG, elytra.writeNbt(new NbtCompound()));
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CRAFTING_ATTACH_ELYTRA;
    }

    private static boolean isValid(ItemStack stack) {
        ColytraConfig.PermissionMode permissionMode = ColytraConfig.permissionMode;
        List<Item> permissionList = ColytraConfig.permissionList;
        boolean isBlacklist = permissionMode == ColytraConfig.PermissionMode.BLACKLIST;
        return isBlacklist != permissionList.contains(stack.getItem())
                && MobEntity.getPreferredEquipmentSlot(stack) == EquipmentSlot.CHEST && !(stack
                .getItem() instanceof ElytraItem) && stack.getItem() == RegsiterItems.DRAGON_CHESTPLATE;
    }
}
