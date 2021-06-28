package com.mr_sword.dragonarmor.config;

import com.mr_sword.dragonarmor.DragonArmor;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.ArrayList;
import java.util.List;

@Config(name = DragonArmor.MOD_ID)
public class ColytraConfigData implements ConfigData {

    @ConfigEntry.Gui.Tooltip(count = 3)
    @Comment("""
            Sets wether the permission list is a blacklist or a whitelist
            BLACKLIST: Only specified items cannot be combined with elytra
            WHITELIST: Only specified items can be combined with elytra""")
    public ColytraConfig.PermissionMode permissionMode = ColytraConfig.PermissionMode.BLACKLIST;

    @ConfigEntry.Gui.Tooltip
    @Comment("List of items by registry name to be blacklisted/whitelisted based on Permission Mode")
    public List<String> permissionList = new ArrayList<>();

    @ConfigEntry.Gui.Tooltip(count = 4)
    @Comment("""
      Sets how the elytra chestplates will behave
      NORMAL: Elytras will exist separately from the chestplate, able to be separated later
      UNISON: Elytras will fuse completely with the chestplate, unable to be separated
      PERFECT: Elytras will fuse completely with the chestplate and flying will not use durability""")
    public ColytraConfig.ColytraMode colytraMode = ColytraConfig.ColytraMode.NORMAL;
}
