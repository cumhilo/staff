package com.github.vcamilx.staff;

import com.github.vcamilx.staff.core.service.IService;
import com.github.vcamilx.staff.module.MainModule;
import me.yushust.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Named;

public final class Staff extends JavaPlugin {

    @Inject
    @Named("staff-service")
    private IService staffService;

    @Override
    public void onEnable() {
        Injector injector = Injector.create(new MainModule(this));
        injector.injectMembers(this);

        saveDefaultConfig();
        staffService.start();
    }

    @Override
    public void onDisable() {
        staffService.stop();
    }
}
