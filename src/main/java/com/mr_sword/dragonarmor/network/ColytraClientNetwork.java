package com.mr_sword.dragonarmor.network;

import com.mr_sword.dragonarmor.DragonArmor;
import com.mr_sword.dragonarmor.config.ColytraConfig;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ColytraClientNetwork {

    public static void setup() {

        if (DragonArmor.isConfigLoaded) {
            ClientPlayNetworking.registerGlobalReceiver(ColytraPackets.SYNC_CONFIG,
                    (client, handler, buf, responseSender) -> {
                        ColytraConfig.ColytraMode mode =
                                ColytraConfig.ColytraMode.valueOf(buf.readString(32767));
                        ColytraConfig.PermissionMode permissionMode =
                                ColytraConfig.PermissionMode.valueOf(buf.readString(32767));
                        int size = buf.readInt();
                        List<Item> items = new ArrayList<>();

                        for (int i = 0; i < size; i++) {
                            String id = buf.readString(32767);
                            Registry.ITEM.getOrEmpty(Identifier.tryParse(id)).ifPresent(items::add);
                        }
                        client.execute(() -> {
                            ColytraConfig.colytraMode = mode;
                            ColytraConfig.permissionMode = permissionMode;
                            ColytraConfig.permissionList = items;
                        });
                    });
        }
    }
}
