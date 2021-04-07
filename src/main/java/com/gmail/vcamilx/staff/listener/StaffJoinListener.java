package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Inject;
import javax.inject.Named;

public class StaffJoinListener implements Listener {

    @Inject
    @Named("staff-manager")
    private Manager manager;

    @EventHandler(priority = EventPriority.LOWEST)
    public void staffJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staff.mode")) {
            if (!manager.isStaffMode(player)) {
                manager.setStaff(player);
            }
        }
    }
}
