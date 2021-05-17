package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.staff.StaffManager;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

@InjectAll
public class StaffInteractInventoryEvent implements Listener {

    private StaffManager staffManager;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (!staffManager.isStaffMode(player)) return;

        event.setCancelled(true);
    }
}
