package com.github.vcamilx.staff.manager.database.implementation;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import redis.clients.jedis.Jedis;

@InjectAll
public class JedisManager {

    private JedisProvider jedisProvider;
    private Gson gson;

    public StaffPlayer deserialized(String key) {
        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (!resource.hexists("staff", key))
                return null;

            return gson.fromJson(resource.hget("staff", key), StaffPlayer.class);
        }
    }
}
