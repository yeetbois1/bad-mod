package com.mr_sword.dragonarmor;

import com.mr_sword.dragonarmor.config.AutoConfigPlugin;
import com.mr_sword.dragonarmor.crafting.ElytraAttachmentRecipe;
import com.mr_sword.dragonarmor.crafting.ElytraDetachmentRecipe;
import com.mr_sword.dragonarmor.registry.Opal;
import com.mr_sword.dragonarmor.registry.RegisterBlocks;
import com.mr_sword.dragonarmor.registry.RegsiterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class DragonArmor implements ModInitializer {

    public static final String MOD_ID = "dragonarmor";

    private static final String ATTACH_ELYTRA = MOD_ID + ":elytra_attachment";
    private static final String DETACH_ELYTRA = MOD_ID + ":elytra_detachment";

    public static boolean isConfigLoaded = false;

    @Override
    public void onInitialize() {

        RegistryKey<ConfiguredFeature<?, ?>> opalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(MOD_ID, "opal_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, opalOre.getValue(), OPAL_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, opalOre);

        RegsiterItems.register();
        RegisterBlocks.register();

        Registry.register(Registry.RECIPE_SERIALIZER, ATTACH_ELYTRA,
                ElytraAttachmentRecipe.CRAFTING_ATTACH_ELYTRA);
        Registry.register(Registry.RECIPE_SERIALIZER, DETACH_ELYTRA,
                ElytraDetachmentRecipe.CRAFTING_DETACH_ELYTRA);

        // Config
        isConfigLoaded = FabricLoader.getInstance().isModLoaded("cloth-config2");

        if (isConfigLoaded) {
            AutoConfigPlugin.init();
        }
        ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> {

            if (isConfigLoaded) {
                AutoConfigPlugin.bake();
            }
        });
        ServerLifecycleEvents.END_DATA_PACK_RELOAD
                .register((minecraftServer, serverResourceManager, b) -> {

                    if (isConfigLoaded) {
                        AutoConfigPlugin.bake();
                    }
                });

    }

    public static ConfiguredFeature<?, ?> OPAL_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    Opal.OPAL_ORE.getDefaultState(),
            9))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.fixed(0),YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(20);
}
