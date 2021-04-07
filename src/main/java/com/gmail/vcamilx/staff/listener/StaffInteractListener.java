package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.inject.Inject;
import javax.inject.Named;

public class StaffInteractListener implements Listener {

    @Inject
    @Named("staff-manager")
    private Manager manager;

    @EventHandler
    public void interaction(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (manager.isStaffMode(player)) {
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                if (player.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE) {
                    if (Bukkit.getOnlinePlayers().size() > 1) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (players != null && !manager.isStaffMode(players)) {
                                player.teleport(players.getLocation());
                            }
                        }
                    }
                }
            }
        }
    }
}
