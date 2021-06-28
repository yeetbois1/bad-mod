package com.mr_sword.dragonarmor.client;

import com.mr_sword.dragonarmor.network.ColytraClientNetwork;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.LivingEntityFeatureRendererRegistrationCallback;

public class DragonArmorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ColytraClientNetwork.setup();
        LivingEntityFeatureRendererRegistrationCallback.EVENT
                .register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper
                        .register(new ColytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
    }
}
