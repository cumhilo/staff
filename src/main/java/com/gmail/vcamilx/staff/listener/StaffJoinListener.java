package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffJoinListener implements Listener {
    private Manager manager;

    @EventHandler
    public void staffJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (Player players : Bukkit.getOnlinePlayers()) {

        }
        if (player.hasPermission("staff.mode")) {
            manager.setStaff(player);
        }
    }
}
