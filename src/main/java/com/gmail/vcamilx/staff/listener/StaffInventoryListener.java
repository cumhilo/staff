package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffInventoryListener implements Listener {X
    private void inventory() {
        /* In this method called inventory, all items will be created,
        which will be in the inventory of the staff mode. */

        // Compass item

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();

        Objects.requireNonNull(compassMeta).setDisplayName(ChatUtil.color("&cCompass"));
        List<String> compassLore = new ArrayList<>();

        compassLore.add(ChatUtil.color("&bTeleport anywhere, as if you were using magic!"));

        compassMeta.setLore(compassLore);

        compass.setItemMeta(compassMeta);

        // Freeze item


    }
}
