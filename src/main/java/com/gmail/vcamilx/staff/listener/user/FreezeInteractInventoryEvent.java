package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.inject.Inject;

public class FreezeInteractInventoryEvent implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void interactInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (freezeManager.isFrozenState(player)) return;

        event.setCancelled(true);
    }
}
