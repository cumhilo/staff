package com.github.vcamilx.staff.manager.mode;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.client.ClientManager;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;

@InjectAll
public class VanishManager {

    private ClientManager clientManager;
    private Staff staff;
    private JedisManager jedisManager;
    private JedisProvider jedisProvider;
    private Gson gson;

    /**
     * Here you can hide a player from other online players on the server.
     *
     * @param player The player who will be hidden from the other players.
     */

    public void setVanish(Player player) {
        Bukkit.getOnlinePlayers().forEach(player1 -> {
            if (!player1.hasPermission("staff.mode")
                    && !player1.canSee(player)
                    && !isVanished(player)
            ) {
                setVanished(player, false);
                player1.showPlayer(staff, player);
                return;
            }

            setVanished(player, true);
            player1.hidePlayer(staff, player);
        });
    }

    public void setVanished(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setSocialSpy(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public boolean isVanished(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).isVanished();
    }
}
