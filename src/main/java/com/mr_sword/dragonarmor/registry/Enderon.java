package com.mr_sword.dragonarmor.registry;

import com.mr_sword.dragonarmor.armor.EnderonArmorMaterial;
import com.mr_sword.dragonarmor.specialitemtypes.EnderonAxeItem;
import com.mr_sword.dragonarmor.specialitemtypes.EnderonHoeItem;
import com.mr_sword.dragonarmor.specialitemtypes.EnderonPickaxeItem;
import com.mr_sword.dragonarmor.tool.EnderonToolMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

public class Enderon {

    public static final Item ENDERON = new Item(new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP).rarity(Rarity.RARE));

    public static ToolItem ENDERON_SWORD = new SwordItem(EnderonToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static ToolItem ENDERON_PICKAXE = new EnderonPickaxeItem(EnderonToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static ToolItem ENDERON_AXE = new EnderonAxeItem(EnderonToolMaterial.INSTANCE, 5, -3.0f, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static ToolItem ENDERON_SHOVEL = new ShovelItem(EnderonToolMaterial.INSTANCE, 1.5f, -3.0f, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static ToolItem ENDERON_HOE = new EnderonHoeItem(EnderonToolMaterial.INSTANCE, -4, 0.0f, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));

    public static final EnderonArmorMaterial enderonArmorMaterial = new EnderonArmorMaterial();

    public static final Item ENDERON_HELMET = new ArmorItem(enderonArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static final Item ENDERON_CHESTPLATE = new ArmorItem(enderonArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static final Item ENDERON_LEGGINGS = new ArmorItem(enderonArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
    public static final Item ENDERON_BOOTS = new ArmorItem(enderonArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
}
