package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import javax.inject.Inject;

public class FreezePickUpItemEvent implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void pickUpItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();

        if (!freezeManager.isFrozenState(player)) return;

        event.setCancelled(true);
    }
}
