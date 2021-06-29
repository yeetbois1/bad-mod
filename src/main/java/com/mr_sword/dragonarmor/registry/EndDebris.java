package com.mr_sword.dragonarmor.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class EndDebris {

    public static final Block END_DEBRIS = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool()
            .strength(30.0f, 1200.0f)
            .sounds(BlockSoundGroup.METAL));
}
