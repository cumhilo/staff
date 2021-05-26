package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.core.service.IService;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;

@InjectAll
public class DatabaseServiceImpl implements IService {

    private Staff staff;
    private JedisProvider jedisProvider;

    public void start() {
        jedisProvider.getJedisPool().getResource().connect();

        if (!jedisProvider.getJedisPool().getResource().isConnected()) {
            Bukkit.getLogger().info("Redis, could not be connected! Please validate that the data is correct.");
            Bukkit.getServer().getPluginManager().disablePlugin(staff);
            return;
        }

        Bukkit.getLogger().info("Redis has been successfully started");
    }

    public void stop() {
        if (jedisProvider.getJedisPool().getResource() != null)
            jedisProvider.getJedisPool().getResource().close();
        Bukkit.getLogger().info("Redis has been successfully stopped");
    }
}
