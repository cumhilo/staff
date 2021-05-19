package com.github.vcamilx.staff.service;

import com.github.vcamilx.staff.core.service.IService;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;

import javax.inject.Named;

@InjectAll
public class StaffService implements IService {

    @Named("listener-service")
    private IService listenerService;

    @Named("command-service")
    private IService commandService;

    public void start() {
        listenerService.start();
        commandService.start();
        Bukkit
                .getLogger()
                .info("All services has been started");
    }

    @Override
    public void stop() {
        listenerService.stop();
        commandService.stop();
        Bukkit
                .getLogger()
                .info("All services has been stopped");
    }
}