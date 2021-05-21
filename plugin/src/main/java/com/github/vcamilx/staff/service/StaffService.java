package com.github.vcamilx.staff.service;

import com.github.vcamilx.staff.core.service.IService;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;

import javax.inject.Named;

@InjectAll
public class StaffService implements IService {

    @Named("command-service")
    private IService commandService;

    @Named("listener-service")
    private IService listenerService;

    @Named("version-service")
    private IService versionService;

    @Named("database-service")
    private IService databaseService;

    public void start() {
        versionService.start();
        commandService.start();
        listenerService.start();
        databaseService.start();

        Bukkit
                .getLogger()
                .info("All services has been started");
    }

    @Override
    public void stop() {
        versionService.stop();
        commandService.stop();
        listenerService.stop();
        databaseService.start();

        Bukkit
                .getLogger()
                .info("All services has been stopped");
    }
}