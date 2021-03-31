package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffMode;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Objects;

public class StaffChatListener implements Listener {

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.isStaffChat(player)) {
            for (Player staffs : Bukkit.getOnlinePlayers()) {
                if (staffs.hasPermission("staff.chat")) {
                    staffs.sendMessage(ChatUtil.translate(
                            Objects.requireNonNull(Staff.getPlugin().getConfig().getString("messages.staff.chat"))
                                    .replace("%player%", player.getName()
                                            .replace("%message%", event.getMessage()))));
                }
            }
            event.setCancelled(true);
        }
    }
}
