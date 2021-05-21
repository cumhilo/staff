package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

@InjectAll
public class StaffInventoryClickListener implements Listener {

    private StaffManager staffManager;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if (!staffManager.isStaff(player)) return;

        event.setCancelled(true);
    }
}