package com.github.vcamilx.staff.manager.mode;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.client.ClientManager;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.github.vcamilx.staff.manager.inventory.InventoryManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import com.github.vcamilx.staff.util.verion.SimpleNMS;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import redis.clients.jedis.Jedis;

@InjectAll
public class StaffManager {

    private Staff staff;
    private ClientManager clientManager;
    private InventoryManager inventoryManager;
    private JedisManager jedisManager;
    private JedisProvider jedisProvider;
    private Gson gson;
    private VanishManager vanishManager;

    public void setStaff(Player player) {
        clientManager.createPlayer(player);

        if (!isStaffMode(player)) {
            setStaffMode(player, true);

            // inventoryManager.setInventory(player, player.getInventory().getContents());
            player.getInventory().clear();

            inventoryManager.inventory(player);

            player.setGameMode(GameMode.CREATIVE);
            vanishManager.setVanish(player);

            SimpleNMS.getNMSHandler().sendTitle(
                    player,
                    ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.title")),
                    ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.subtitle")),
                    staff.getConfig().getInt("messages.staff.join.title.fadeIn"),
                    staff.getConfig().getInt("messages.staff.join.title.stay"),
                    staff.getConfig().getInt("messages.staff.join.title.fadeOut"));

            player.sendMessage(ChatUtil.color(staff.getConfig().getString("messages.staff.join.chat")));
            return;
        }

        setStaffMode(player, false);

        // player.getInventory().setContents(inventoryManager.getInventory(player));
        player.setGameMode(GameMode.SURVIVAL);
        vanishManager.setVanish(player);

        SimpleNMS.getNMSHandler().sendTitle(
                player,
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.title")),
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.subtitle")),
                staff.getConfig().getInt("messages.staff.leave.title.fadeIn"),
                staff.getConfig().getInt("messages.staff.leave.title.stay"),
                staff.getConfig().getInt("messages.staff.leave.title.fadeOut"));

        player.sendMessage(ChatUtil.color(staff.getConfig().getString("messages.staff.leave.chat")));
    }

    /**
     * Here, we will find a method which will allow us to add a metadata and the inventory to the player without the
     * need to repeat code unnecessarily, besides allowing us to have everything more organized.
     *
     * @param player the player to which the metadata and the inventory is to be applied
     */

    public void setStaffMode(Player player, boolean mode) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setStaffMode(mode);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    /**
     * @param player the player we want to check if he is in StaffMode
     * @return true or false, depending on whether the player exists in the map.
     */

    public boolean isStaffMode(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).isStaffMode();
    }
}