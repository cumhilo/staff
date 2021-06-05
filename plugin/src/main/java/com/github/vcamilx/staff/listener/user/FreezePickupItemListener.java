package com.github.vcamilx.staff.listener.user;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import javax.inject.Inject;

public class FreezePickupItemListener implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (freezeManager.isFrozen(player)) {
            event.setCancelled(true);
        }
    }
}