package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@InjectAll
public class StaffBlockPlaceListener implements Listener {

    private StaffManager staffManager;

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isStaff(player)) {
            player.sendMessage(ChatUtil.color("&cYou cannot place bocks when you are in staff mode!"));
            event.setCancelled(true);
        }
    }
}
