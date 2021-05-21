package com.github.vcamilx.staff.module;

import com.github.vcamilx.staff.core.service.IService;
import com.github.vcamilx.staff.service.StaffService;
import com.github.vcamilx.staff.service.implementation.CommandServiceImpl;
import com.github.vcamilx.staff.service.implementation.DatabaseServiceImpl;
import com.github.vcamilx.staff.service.implementation.ListenerServiceImpl;
import com.github.vcamilx.staff.service.implementation.VersionServiceImpl;
import me.yushust.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bindService("staff-service", StaffService.class);
        bindService("command-service", CommandServiceImpl.class);
        bindService("listener-service", ListenerServiceImpl.class);
        bindService("version-service", VersionServiceImpl.class);
        bindService("database-service", DatabaseServiceImpl.class);
    }

    private void bindService(String name, Class<? extends IService> clazz) {
        bind(IService.class).named(name).to(clazz).singleton();
    }
}
