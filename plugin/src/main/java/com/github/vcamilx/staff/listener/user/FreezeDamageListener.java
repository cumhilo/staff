package com.github.vcamilx.staff.listener.user;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import javax.inject.Inject;

public class FreezeDamageListener implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        if (freezeManager.isFrozen(player)) event.setCancelled(true);
    }
}