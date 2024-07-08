package com.github.cumhilo.staff;

import com.github.cumhilo.staff.commands.CommandModule;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffPlugin
        extends JavaPlugin {

    @Override
    public void onEnable() {
        final var commandModule = new CommandModule(this);
        commandModule.configure();

        getLogger().info("Staff plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Staff plugin is disabled!");
    }
}
