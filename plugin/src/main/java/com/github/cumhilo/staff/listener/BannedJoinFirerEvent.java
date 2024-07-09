package com.github.cumhilo.staff.listener;

import com.github.cumhilo.staff.event.custom.specific.BannedJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BannedJoinFirerEvent
        implements Listener {

    @EventHandler
    public void onBannedPlayerJoin(BannedJoinEvent event) {
        // TODO: changue Player#kickPlayer to Player#kick(Component), and implements the Layouts system, so no need to use the punishment reason directly
        event.player().kickPlayer(event.punishment().reason());
    }
}
