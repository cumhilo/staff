package com.github.cumhilo.staff.event.firer;

import com.github.cumhilo.staff.event.custom.PunishedJoinEvent;
import com.github.cumhilo.staff.event.custom.specific.BannedJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class BannedJoinFirerEvent
        implements Listener {

    private final PluginManager pluginManager;

    public BannedJoinFirerEvent(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @EventHandler
    public void onBannedPlayerJoin(PunishedJoinEvent event) {
        event.punishments().stream()
                .filter(punishment -> punishment.type().isBan())
                .findFirst()
                .ifPresent(punishment -> pluginManager.callEvent(new BannedJoinEvent(event.user(), event.player(), punishment)));
    }
}
