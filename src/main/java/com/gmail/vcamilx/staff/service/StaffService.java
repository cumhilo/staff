package com.gmail.vcamilx.staff.service;

import me.yushust.inject.InjectAll;

import javax.inject.Named;

@InjectAll
public class StaffService implements IService {

    @Named("listener-service")
    private IService listenerService;

    @Named("command-service")
    private IService commandServiceImpl;


    @Override
    public void start() {
        listenerService.start();
        commandServiceImpl.start();
    }
}
