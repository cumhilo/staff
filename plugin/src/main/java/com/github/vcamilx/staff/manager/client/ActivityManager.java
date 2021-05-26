package com.github.vcamilx.staff.manager.client;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;

import java.util.Date;

@InjectAll
public class ActivityManager {

    private ClientManager clientManager;
    private JedisProvider jedisProvider;
    private JedisManager jedisManager;
    private Gson gson;

    public void setFirstActivity(Player player, Date date) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setFirstActivity(date);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setLastActivity(Player player, Date date) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setLastActivity(date);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public Date getFirstActivity(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getFirstActivity();
    }

    public Date getLastActivity(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getLastActivity();
    }
}
