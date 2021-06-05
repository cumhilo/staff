package com.github.vcamilx.staff.listener.user;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import javax.inject.Inject;

public class FreezeDropItemListener implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (freezeManager.isFrozen(player)) {
            event.setCancelled(true);
        }
    }
}