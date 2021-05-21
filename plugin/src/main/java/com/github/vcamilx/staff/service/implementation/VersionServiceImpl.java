package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.core.service.IService;
import com.github.vcamilx.staff.util.verion.SimpleNMS;
import org.bukkit.Bukkit;

import javax.inject.Inject;

public class VersionServiceImpl implements IService {

    @Inject
    private SimpleNMS simpleNMS;

    public void start() {
        simpleNMS.enableNMS();
        Bukkit.getLogger().info("Server version: " + simpleNMS.getVersion());
    }

    public void stop() {
        simpleNMS.disableNMS();
    }
}
