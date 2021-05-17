package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.staff.StaffManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import javax.inject.Inject;

public class StaffDropItemEvent implements Listener {

    @Inject
    private StaffManager staffManager;

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (!staffManager.isStaffMode(player)) return;

        event.setCancelled(true);
    }
}
