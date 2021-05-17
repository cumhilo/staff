package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import javax.inject.Inject;

public class FreezeProjectileLaunchEvent implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

        Projectile projectile = event.getEntity();

        if (!(projectile.getShooter() instanceof Player)) return;

        Player player = (Player) projectile.getShooter();

        if (freezeManager.isFrozenState(player)) return;

        player.sendMessage(ChatUtil.color("&cYou cannot launch projectiles when you are frozen!"));
        event.setCancelled(true);
    }
}
