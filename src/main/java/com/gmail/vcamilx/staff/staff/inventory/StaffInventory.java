package com.gmail.vcamilx.staff.staff.inventory;

import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import team.unnamed.gui.core.item.type.ItemBuilder;

import java.util.Collection;

public class StaffInventory {

    /**
     * The inventory method, inventory is a small "utility" for the StaffManager class
     *
     * @param player who, in turn, is the player to whom the staff-mode items will be applied.
     * @see com.gmail.vcamilx.staff.staff.StaffManager
     * <p>
     * and it accepts as input parameter
     */

    public void inventory(Player player) {
        /* In this method called inventory, all items will be created,
        which will be in the inventory of the staff mode. */

        // Compass item 🕊

        ItemStack compass = ItemBuilder
                .newBuilder(Material.COMPASS)
                .setName(ChatUtil.color("&9 » &b&lCompass &9 «"))
                .setLore(ChatUtil.colorArrays("", "&7Teleport anywhere, as if you were using magic!", ""))
                .build();

        player.getInventory().setItem(0, compass);

        // Freeze item 🥶

        ItemStack ice = ItemBuilder
                .newBuilder(Material.ICE)
                .setName(ChatUtil.color("&9 » &bFreeze machine &9 «"))
                .setLore("", "Freeze anybody!", "")
                .build();

        player.getInventory().setItem(1, ice);

        // Inventory see item 🔎

        ItemStack book = ItemBuilder
                .newBuilder(Material.BOOK)
                .setName(ChatUtil.color("&9 » &bInventory inspector &9 «"))
                .setLore("", "See a player inventory!", "")
                .build();

        player.getInventory().setItem(4, book);

        // Staff list item 📃

        ItemStack playerHead = ItemBuilder
                .newBuilder(Material.PLAYER_HEAD)
                .setName(ChatUtil.color("&9 » &bOnline staff &9 «"))
                .setLore("", "Staff online list!", "")
                .build();

        player.getInventory().setItem(7, playerHead);

        // Random teleport item 🪁

        ItemStack enderEye = ItemBuilder
                .newBuilder(Material.ENDER_EYE)
                .setName(ChatUtil.color("&9 » &bRandom teleport &9 «"))
                .setLore("", "Teleport randomly!", "")
                .build();

        player.getInventory().setItem(8, enderEye);
    }
}
