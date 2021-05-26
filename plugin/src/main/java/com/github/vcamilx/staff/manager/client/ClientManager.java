package com.github.vcamilx.staff.manager.client;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;

import java.util.UUID;

@InjectAll
public class ClientManager {

    private JedisProvider jedisProvider;
    private JedisManager jedisManager;
    private Gson gson;

    public boolean createPlayer(Player player) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (!resource.hexists("staff", key)) {
                resource.hset("staff", key, gson.toJson(new StaffPlayer(player)));
                return true;
            }
        }
        return false;
    }

    public UUID getPlayerId(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getPlayerId();
    }

    public void setPlayerName(Player player, String playerName) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setPlayerName(playerName);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setPlayerId(Player player, UUID uuid) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setPlayerId(uuid);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public String getPlayer(Player player) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (!resource.hexists("staff", key))
                return "This player is null or doesn't exists in the database";

            return resource.hget("staff", key);
        }
    }

    public String getPlayerName(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getPlayerName();
    }
}
