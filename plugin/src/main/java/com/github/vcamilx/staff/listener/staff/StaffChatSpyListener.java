package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.manager.mode.SocialSpyManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@InjectAll
public class StaffChatSpyListener implements Listener {

    private Staff staff;
    private SocialSpyManager socialSpyManager;

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (socialSpyManager.isSocialSpy(player)) {
            player.sendMessage(ChatUtil.color(staff.getConfig().getString("messages.staff.spy"))
                    .replace("%player%", player.getName())
                    .replace("%message%", event.getMessage()));
        }
    }
}
