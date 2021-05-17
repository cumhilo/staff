package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.FreezeManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

@InjectAll
public class FreezeMoveListener implements Listener {

    private FreezeManager freezeManager;
    private Staff staff;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location eventFrom = event.getFrom();
        Location eventTo = event.getTo();

        if (freezeManager.isFrozenState(player)) return;

        if (eventTo != null && (eventFrom.getBlockZ() != eventTo.getBlockZ() || eventFrom.getBlockX() != eventTo.getBlockX())) {
            player.teleport(eventFrom);

            for (String freezeMessage : staff.getConfig().getStringList("messages.freeze.target.freeze")) {
                player.sendMessage(ChatUtil.color(freezeMessage)
                        .replaceAll("%frozen%", player.getName()));
            }
        }
    }
}
