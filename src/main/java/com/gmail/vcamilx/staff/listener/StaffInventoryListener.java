package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.inject.Inject;
import javax.inject.Named;

public class StaffInventoryListener implements Listener {

    @Inject
    @Named("staff-manager")
    private Manager manager;

    @EventHandler
    public void staffInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (manager.isStaffMode(player)) {
            event.setCancelled(true);
        }
    }
}
