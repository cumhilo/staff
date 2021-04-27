package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import javax.inject.Inject;

public class FreezeDamageEvent implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void damage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();

        if (!freezeManager.isFrozenState(player)) event.setCancelled(true);
    }
}
