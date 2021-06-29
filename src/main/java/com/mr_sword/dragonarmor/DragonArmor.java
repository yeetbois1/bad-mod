package com.mr_sword.dragonarmor;

import com.mr_sword.dragonarmor.config.AutoConfigPlugin;
import com.mr_sword.dragonarmor.crafting.ElytraAttachmentRecipe;
import com.mr_sword.dragonarmor.crafting.ElytraDetachmentRecipe;
import com.mr_sword.dragonarmor.registry.RegisterBlocks;
import com.mr_sword.dragonarmor.registry.RegsiterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.registry.Registry;

public class DragonArmor implements ModInitializer {

    public static final String MOD_ID = "dragonarmor";

    private static final String ATTACH_ELYTRA = MOD_ID + ":elytra_attachment";
    private static final String DETACH_ELYTRA = MOD_ID + ":elytra_detachment";

    public static boolean isConfigLoaded = false;

    @Override
    public void onInitialize() {

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
}
