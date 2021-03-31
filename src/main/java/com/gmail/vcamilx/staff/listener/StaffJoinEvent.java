package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.StaffMode;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffJoinEvent implements Listener {

    @EventHandler
    public void staffJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staff.mode")) {
            player.sendMessage(ChatUtil.translate("&aIt works: " + getClass().getName()));
            StaffMode.setStaff(player);
        }
    }
}
