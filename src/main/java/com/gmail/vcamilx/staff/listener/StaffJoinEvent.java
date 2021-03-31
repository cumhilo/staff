package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.StaffMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffJoinEvent implements Listener {

    @EventHandler
    public void staffJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staff.mode")) {
            StaffMode.setStaff(player);
        }
    }
}
