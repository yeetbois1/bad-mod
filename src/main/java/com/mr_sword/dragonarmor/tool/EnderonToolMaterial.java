package com.mr_sword.dragonarmor.tool;

import com.mr_sword.dragonarmor.registry.Enderon;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EnderonToolMaterial implements ToolMaterial {

    public static final EnderonToolMaterial INSTANCE = new EnderonToolMaterial();

    @Override
    public int getDurability() {
        return 1869;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Enderon.ENDERON);
    }
}
