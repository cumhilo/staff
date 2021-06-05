package com.github.vcamilx.staff.listener.user;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import javax.inject.Inject;

public class FreezeDamageByEntityListener implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();

        if (freezeManager.isFrozen(player)) {
            event.setCancelled(true);
        }
    }
}