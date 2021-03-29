package com.gmail.vcamilx.staff;

import com.gmail.vcamilx.staff.service.StaffService;
import org.bukkit.plugin.java.JavaPlugin;

public final class Staff extends JavaPlugin {

    public static Staff plugin;

    @Override
    public void onEnable() {
        new StaffService().start();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin has been disabled");
    }
}
