package com.github.vcamilx.staff.manager.database.implementation;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.UUID;

@InjectAll
public class JedisManager {

    private JedisProvider jedisProvider;
    private Gson gson;

    public boolean createPlayer(Player player) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (!resource.hexists("staff", key)) {
                resource.hset("staff", key, gson.toJson(new StaffPlayer(player)));
                return true;
            }
        }
        return false;
    }

    public String getPlayer(Player player) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (!resource.hexists("staff", key))
                return "This player is null or doesn't exists in the database";

            return resource.hget("staff", key);
        }
    }

    public String getPlayerName(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getPlayerName();
    }

    public UUID getPlayerId(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getPlayerId();
    }

    public Date getFirstActivity(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getFirstActivity();
    }

    public Date getLastActivity(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getLastActivity();
    }

    public int getSanctions(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getSanctions();
    }

    public boolean isStaffMode(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).isStaffMode();
    }

    public boolean isStaffChat(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).isStaffChat();
    }

    public boolean isSocialSpy(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).isSocialSpy();
    }

    public boolean isVanished(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).isVanished();
    }

    public ItemStack[] getInventory(Player player) {
        String key = player.getUniqueId().toString();

        return deserialized(key).getInventory();
    }

    public void setPlayerName(Player player, String playerName) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setPlayerName(playerName);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setPlayerId(Player player, UUID uuid) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setPlayerId(uuid);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setFirstActivity(Player player, Date date) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setFirstActivity(date);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setLastActivity(Player player, Date date) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setLastActivity(date);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setSanctions(Player player, int number) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setSanctions(number);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setStaffMode(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setStaffMode(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setStaffChat(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setStaffChat(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setSocialSpy(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setSocialSpy(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setVanished(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setSocialSpy(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public void setInventory(Player player, ItemStack[] inventory) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (resource.hexists("staff", key))
                createPlayer(player);

            StaffPlayer deserialized = deserialized(key);
            deserialized.setInventory(inventory);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public StaffPlayer deserialized(String key) {
        try (Jedis resource = jedisProvider.getJedisPool()) {
            if (!resource.hexists("staff", key))
                return null;

            return gson.fromJson(resource.hget("staff", key), StaffPlayer.class);
        }
    }
}
