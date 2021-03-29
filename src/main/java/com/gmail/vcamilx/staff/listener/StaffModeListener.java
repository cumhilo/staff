package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.StaffEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class StaffModeListener implements Listener {

    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            StaffEntity staffEntity = new StaffEntity(player);
            if (!staffEntity.isStaffMode()) {
                staffEntity.setStaffMode(true);
                return;
            }
            staffEntity.setStaffMode(false);
        }
    }
}
