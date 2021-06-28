package com.mr_sword.dragonarmor.crafting;

import com.mr_sword.dragonarmor.config.ColytraConfig;
import com.mr_sword.dragonarmor.util.ColytraNbt;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ElytraDetachmentRecipe extends SpecialCraftingRecipe {

    public static final SpecialRecipeSerializer<ElytraDetachmentRecipe> CRAFTING_DETACH_ELYTRA = new SpecialRecipeSerializer<>(
            ElytraDetachmentRecipe::new);

    public ElytraDetachmentRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {

        if (ColytraConfig.colytraMode != ColytraConfig.ColytraMode.NORMAL) {
            return false;
        }
        ItemStack itemstack = ItemStack.EMPTY;

        for (int i = 0; i < inv.size(); ++i) {
            ItemStack currentStack = inv.getStack(i);

            if (currentStack.isEmpty()) {
                continue;
            }

            if (!itemstack.isEmpty() || !ColytraNbt.hasUpgrade(currentStack)) {
                return false;
            }
            itemstack = currentStack;
        }
        return !itemstack.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
        ItemStack itemstack = ItemStack.EMPTY;

        for (int k = 0; k < inv.size(); ++k) {
            ItemStack currentStack = inv.getStack(k);

            if (!currentStack.isEmpty()) {

                if (!itemstack.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                itemstack = ColytraNbt.getElytra(currentStack);
            }
        }

        if (!itemstack.isEmpty()) {
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inv) {
        DefaultedList<ItemStack> nonnulllist = DefaultedList.ofSize(inv.size(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack currentStack = inv.getStack(i);

            if (!currentStack.isEmpty() && ColytraNbt.hasUpgrade(currentStack)) {
                currentStack.removeSubTag(ColytraNbt.ELYTRA_TAG);
                nonnulllist.set(i, currentStack.copy());
                break;
            }
        }
        return nonnulllist;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CRAFTING_DETACH_ELYTRA;
    }
}
