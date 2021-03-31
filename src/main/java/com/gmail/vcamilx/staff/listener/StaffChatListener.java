package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.StaffMode;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChatListener implements Listener {

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.isStaffChat(player)) {
            for (Player staffs : Bukkit.getOnlinePlayers()) {
                if (staffs.hasPermission("staff.chat")) {
                    staffs.sendMessage(ChatUtil.translate("&7(&9StaffChat&7) -> &b" + player.getName() + " &7-> &a" + event.getMessage()));
                }
            }
            event.setCancelled(true);
        }
    }
}
