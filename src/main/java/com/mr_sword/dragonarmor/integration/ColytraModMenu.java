package com.mr_sword.dragonarmor.integration;

import com.mr_sword.dragonarmor.DragonArmor;
import com.mr_sword.dragonarmor.config.AutoConfigPlugin;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ColytraModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {

        if (DragonArmor.isConfigLoaded) {
            return AutoConfigPlugin::getConfigScreen;
        } else {
            return screen -> null;
        }
    }
}
