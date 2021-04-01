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
        saveDefaultConfig();
        new StaffService().start();
    }

    @Override
    public void onDisable() {
        Staff.plugin = null;
    }
}
