package com.mr_sword.dragonarmor.registry;

import com.mr_sword.dragonarmor.DragonArmor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(DragonArmor.MOD_ID, "end_debris"), EndDebris.END_DEBRIS);
        Registry.register(Registry.BLOCK, new Identifier(DragonArmor.MOD_ID, "end_steel_block"), EndSteel.END_STEEL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(DragonArmor.MOD_ID, "opal_ore"), Opal.OPAL_ORE);
    }
}
