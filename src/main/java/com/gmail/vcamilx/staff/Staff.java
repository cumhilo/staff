package com.gmail.vcamilx.staff;

import com.gmail.vcamilx.staff.service.StaffService;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Staff extends JavaPlugin {

    @Getter
    private static Staff plugin;

    @Override
    public void onEnable() {
        Staff.plugin = this;
        new StaffService().start();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin has been disabled");
        Staff.plugin = null;
    }
}
