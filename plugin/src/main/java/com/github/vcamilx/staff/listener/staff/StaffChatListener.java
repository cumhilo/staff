package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.manager.mode.StaffManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@InjectAll
public class StaffChatListener implements Listener {

    private Staff staff;
    private StaffManager staffManager;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (staffManager.isStaff(player)) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (players.hasPermission("staff.chat")) {
                    players.sendMessage(ChatUtil.color(
                            staff.getConfig().getString("messages.staff.chat"))
                            .replace("%player%", player.getName())
                            .replace("%message%", event.getMessage()));
                }
            }

            event.setCancelled(true);
        }
    }
}