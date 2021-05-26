package com.github.vcamilx.staff.manager.sanctions;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.client.ClientManager;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.google.gson.Gson;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;

public class SanctionManager {

    private ClientManager clientManager;
    private JedisProvider jedisProvider;
    private JedisManager jedisManager;
    private Gson gson;

    public void setSanctions(Player player, int number) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setSanctions(number);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void addSanction(Player player) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setSanctions(getSanctions(player) + 1);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public int getSanctions(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getSanctions();
    }
}
