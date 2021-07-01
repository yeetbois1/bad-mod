package com.mr_sword.dragonarmor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;

public class Opal {

    public static final Item OPAL = new Item(new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Block OPAL_ORE = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool().strength(10.0f, 300.0f)
            .sounds(BlockSoundGroup.METAL));
    public static final Item OPAL_ORE_ITEM = new BlockItem(OPAL_ORE, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
}
