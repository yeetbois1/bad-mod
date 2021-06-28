package com.mr_sword.dragonarmor.config;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ColytraConfig {

    public static ColytraConfig.PermissionMode permissionMode = PermissionMode.BLACKLIST;
    public static List<Item> permissionList = new ArrayList<>();
    public static ColytraMode colytraMode = ColytraMode.NORMAL;

    public enum PermissionMode {
        BLACKLIST, WHITELIST
    }

    public enum ColytraMode {
        NORMAL, UNISON, PERFECT
    }
}
