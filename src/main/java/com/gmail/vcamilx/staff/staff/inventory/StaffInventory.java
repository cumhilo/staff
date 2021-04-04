package com.gmail.vcamilx.staff.staff.inventory;

import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffInventory {
    public void inventory(Player player) {
        /* In this method called inventory, all items will be created,
        which will be in the inventory of the staff mode. */

        // Compass item

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();

        Objects.requireNonNull(compassMeta).setDisplayName(ChatUtil.color("&cCompass"));
        List<String> compassLore = new ArrayList<>();

        compassLore.add(ChatUtil.color("&eTeleport anywhere, as if you were using magic!"));

        compassMeta.setLore(compassLore);

        compass.setItemMeta(compassMeta);

        player.getInventory().setItem(0, compass);

        // Freeze item

        ItemStack freeze = new ItemStack(Material.ICE);
        ItemMeta freezeMeta = freeze.getItemMeta();

        Objects.requireNonNull(freezeMeta).setDisplayName(ChatUtil.color("&cFreeze machine"));
        List<String> freezeLore = new ArrayList<>();

        freezeLore.add(ChatUtil.color("&eFreeze anybody!"));

        freezeMeta.setLore(freezeLore);

        freeze.setItemMeta(freezeMeta);

        player.getInventory().setItem(1, freeze);


        // Inventory see item

        ItemStack inventory = new ItemStack(Material.BOOK);
        ItemMeta inventoryMeta = inventory.getItemMeta();

        Objects.requireNonNull(inventoryMeta).setDisplayName(ChatUtil.color("&cInventory inspector"));
        List<String> inventoryLore = new ArrayList<>();

        inventoryLore.add(ChatUtil.color("&eSee a player inventory!"));

        inventoryMeta.setLore(inventoryLore);

        inventory.setItemMeta(inventoryMeta);

        player.getInventory().setItem(4, inventory);

        // Staff list item

        ItemStack staff = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta staffMeta = staff.getItemMeta();

        Objects.requireNonNull(staffMeta).setDisplayName(ChatUtil.color("&cOnline staff"));
        List<String> staffLore = new ArrayList<>();

        staffLore.add(ChatUtil.color("&eStaff online list!"));

        staffMeta.setLore(staffLore);

        staff.setItemMeta(staffMeta);

        player.getInventory().setItem(7, staff);

        // Random teleport item

        ItemStack teleport = new ItemStack(Material.ENDER_EYE);
        ItemMeta teleportMeta = teleport.getItemMeta();

        Objects.requireNonNull(teleportMeta).setDisplayName(ChatUtil.color("&cRandom teleport"));
        List<String> teleportLore = new ArrayList<>();

        teleportLore.add(ChatUtil.color("&eTeleport randomly!"));

        teleportMeta.setLore(teleportLore);

        teleport.setItemMeta(teleportMeta);

        player.getInventory().setItem(8, teleport);
    }
}
