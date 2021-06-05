package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import javax.inject.Inject;

public class StaffPickupItemListener implements Listener {

    @Inject
    private StaffManager staffManager;

    @EventHandler
    public void onStaffPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isStaffMode(player)) {
            event.setCancelled(true);
        }
    }
}