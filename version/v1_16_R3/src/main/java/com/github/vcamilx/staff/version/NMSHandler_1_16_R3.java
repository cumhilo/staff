package com.github.vcamilx.staff.version;

import com.github.vcamilx.staff.core.nms.NMSHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import team.unnamed.gui.core.item.type.ItemBuilder;

public class NMSHandler_1_16_R3 implements NMSHandler {

    public ItemStack compass(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.COMPASS)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public ItemStack ice(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.ICE)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public ItemStack book(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.BOOK)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public ItemStack lead(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.LEAD)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public ItemStack playerHead(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.PLAYER_HEAD)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public ItemStack enderEye(String name, String... lore) {
        return ItemBuilder
                .newBuilder(Material.ENDER_EYE)
                .setName(name)
                .setLore(lore)
                .build();
    }

    public void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }
}
