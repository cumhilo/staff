package com.gmail.vcamilx.staff;

import com.gmail.vcamilx.staff.module.MainModule;
import com.gmail.vcamilx.staff.service.IService;
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

        staffService.start();
    }
}
