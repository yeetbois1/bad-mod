package com.mr_sword.dragonarmor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;

public class EndSteel {

    public static final Item RAW_END_STEEL = new Item(new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item END_STEEL = new Item(new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP).rarity(Rarity.UNCOMMON));

    public static final Block END_STEEL_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(15.0f, 600.0f)
            .sounds(BlockSoundGroup.METAL));
    public static final Item END_STEEL_BLOCK_ITEM = new BlockItem(END_STEEL_BLOCK, new Item.Settings().group(RegsiterItems.DRAGON_ITEM_GROUP));
}
