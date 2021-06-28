package com.mr_sword.dragonarmor.registry;

import com.mr_sword.dragonarmor.DragonArmor;
import com.mr_sword.dragonarmor.armor.DragonArmorMaterial;
import com.mr_sword.dragonarmor.specialitemtypes.ArmorWallBlockItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegsiterItems {

    public static final ItemGroup DRAGON_ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(DragonArmor.MOD_ID, "dragon_item_group"))
            .icon(() -> new ItemStack(DragonScale.DRAGON_SCALE))
            .build();

    public static final ArmorMaterial DRAGON_ARMOR_MATERIAL = new DragonArmorMaterial();

    public static final Item DRAGON_HELMET = new ArmorItem(DRAGON_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(DRAGON_ITEM_GROUP));
    public static final Item DRAGON_ARMORED_DRAGON_HEAD = new ArmorWallBlockItem(DRAGON_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(DRAGON_ITEM_GROUP), Blocks.DRAGON_HEAD, Blocks.DRAGON_WALL_HEAD);
    public static final Item DRAGON_CHESTPLATE = new ArmorItem(DRAGON_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(DRAGON_ITEM_GROUP));
    public static final Item DRAGON_LEGGINGS = new ArmorItem(DRAGON_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(DRAGON_ITEM_GROUP));
    public static final Item DRAGON_BOOTS = new ArmorItem(DRAGON_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(DRAGON_ITEM_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_scale"), DragonScale.DRAGON_SCALE);

        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_helmet"), DRAGON_HELMET);
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_chestplate"), DRAGON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_leggings"), DRAGON_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_boots"), DRAGON_BOOTS);

        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "dragon_armored_dragon_head"), DRAGON_ARMORED_DRAGON_HEAD);

        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "raw_end_steel"), EndSteel.RAW_END_STEEL);
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "end_steel"), EndSteel.END_STEEL);

        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "enderium_shard"), Enderium.ENDERIUM_SHARD);
        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "enderium_ingot"), Enderium.ENDERIUM_INGOT);

        Registry.register(Registry.ITEM, new Identifier(DragonArmor.MOD_ID, "enderon"), Enderon.ENDERON);

    }
}
