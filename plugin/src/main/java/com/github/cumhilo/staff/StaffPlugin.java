package com.github.cumhilo.staff;

import org.bukkit.plugin.java.JavaPlugin;

public class StaffPlugin
        extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Staff plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Staff plugin is disabled!");
    }
}
