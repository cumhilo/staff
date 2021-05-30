package com.github.vcamilx.staff.manager.inventory;

import com.github.vcamilx.staff.core.player.StaffPlayer;
import com.github.vcamilx.staff.manager.client.ClientManager;
import com.github.vcamilx.staff.manager.database.JedisProvider;
import com.github.vcamilx.staff.manager.database.implementation.JedisManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import com.github.vcamilx.staff.util.verion.SimpleNMS;
import com.google.gson.Gson;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import redis.clients.jedis.Jedis;

@InjectAll
public class InventoryManager {

    private ClientManager clientManager;
    private JedisProvider jedisProvider;
    private JedisManager jedisManager;
    private Gson gson;

    /**
     * The inventory method, inventory is a small "utility" for the {@link com.github.vcamilx.staff.manager.mode.StaffManager}
     * class
     *
     * @param player who, in turn, is the player to whom the staff-mode items will be applied. and it accepts as input
     *               parameter
     */

    public void inventory(Player player) {
        /* In this method called inventory, all items will be created,
        which will be in the inventory of the staff mode. */

        // Compass item 🕊

        ItemStack compass = SimpleNMS.getNMSHandler().compass(
                ChatUtil.color("&9 » &b&lCompass &9 «"),
                "", "Teleport anywhere, as if you were using magic!", "");

        player.getInventory().setItem(0, compass);

        // Freeze item 🥶

        ItemStack ice = SimpleNMS.getNMSHandler().ice(
                ChatUtil.color("&9 » &bFreeze machine &9 «"),
                "", "Freeze anybody!", "");

        player.getInventory().setItem(1, ice);

        // Inventory see item 🔎

        ItemStack book = SimpleNMS.getNMSHandler().book(
                ChatUtil.color("&9 » &bInventory inspector &9 «"),
                "", "See a player inventory!", "");

        player.getInventory().setItem(4, book);

        // Staff list item 📃

        ItemStack playerHead = SimpleNMS.getNMSHandler().playerHead(
                ChatUtil.color("&9 » &bOnline staff &9 «"),
                "", "Staff online list!", "");

        player.getInventory().setItem(7, playerHead);

        // Random teleport item

        ItemStack enderEye = SimpleNMS.getNMSHandler().enderEye(
                ChatUtil.color("&9 » &bRandom teleport &9 «"),
                "", "Teleport randomly!", "");

        player.getInventory().setItem(8, enderEye);
    }

    /*public void setInventory(Player player, ItemStack[] inventory) {
        String key = player.getUniqueId().toString();

        try (Jedis resource = jedisProvider.getJedisPool().getResource()) {
            if (resource.hexists("staff", key))
                clientManager.createPlayer(player);

            StaffPlayer deserialized = jedisManager.deserialized(key);
            deserialized.setInventory(inventory);

            String serialized = gson.toJson(deserialized);
            resource.hset("staff", key, serialized);
        }
    }

    public ItemStack[] getInventory(Player player) {
        String key = player.getUniqueId().toString();

        return jedisManager.deserialized(key).getInventory();
    }*/
}