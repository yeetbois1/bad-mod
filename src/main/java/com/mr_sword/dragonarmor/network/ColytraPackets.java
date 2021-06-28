package com.mr_sword.dragonarmor.network;

import com.mr_sword.dragonarmor.DragonArmor;
import com.mr_sword.dragonarmor.config.ColytraConfig;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class ColytraPackets {

    public static Identifier SYNC_CONFIG = new Identifier(DragonArmor.MOD_ID, "sync_config");

    public static PacketByteBuf writeConfigPacket() {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString(ColytraConfig.colytraMode.toString());
        buf.writeString(ColytraConfig.permissionMode.toString());
        List<Item> itemsList = ColytraConfig.permissionList;
        buf.writeInt(itemsList.size());

        for (Item item : itemsList) {
            buf.writeString(Registry.ITEM.getId(item).toString());
        }
        return buf;
    }
}
