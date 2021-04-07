package com.gmail.vcamilx.staff.module;

import com.gmail.vcamilx.staff.service.IService;
import com.gmail.vcamilx.staff.service.StaffService;
import com.gmail.vcamilx.staff.service.implementation.CommandServiceImpl;
import com.gmail.vcamilx.staff.service.implementation.ListenerServiceImpl;
import me.yushust.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IService.class).named("staff-service").to(StaffService.class).singleton();
        bind(IService.class).named("command-service").to(CommandServiceImpl.class).singleton();
        bind(IService.class).named("listener-service").to(ListenerServiceImpl.class).singleton();
    }
}
