package com.github.cumhilo.staff.event.firer;

import com.github.cumhilo.staff.event.custom.PunishedJoinEvent;
import com.github.cumhilo.staff.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginManager;

public class PunishedJoinFirerEvent
        implements Listener {

    private final PluginManager pluginManager;

    public PunishedJoinFirerEvent(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @EventHandler
    public void onPunishedPlayerJoin(PlayerLoginEvent event) {
        final var player = event.getPlayer();
        final var user = User.of(player);

        pluginManager.callEvent(new PunishedJoinEvent(user, player, user.sanctions().activePunishments()));
    }
}
