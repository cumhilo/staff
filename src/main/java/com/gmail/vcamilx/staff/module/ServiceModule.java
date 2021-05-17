package com.gmail.vcamilx.staff.module;

import com.gmail.vcamilx.staff.service.IService;
import com.gmail.vcamilx.staff.service.StaffService;
import com.gmail.vcamilx.staff.service.implementation.CommandServiceImpl;
import com.gmail.vcamilx.staff.service.implementation.ListenerServiceImpl;
import me.yushust.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bindService("staff-service", StaffService.class);
        bindService("command-service", CommandServiceImpl.class);
        bindService("listener-service", ListenerServiceImpl.class);
    }

    private void bindService(String name, Class<? extends IService> target) {
        bind(IService.class).named(name).to(target).singleton();
    }
}
