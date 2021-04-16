package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.staff.StaffManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@InjectAll
public class StaffPlaceBlockEvent implements Listener {

    private StaffManager staffManager;

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isStaffMode(player)) {
            player.sendMessage(ChatUtil.color("&cYou cannot place bocks when you are in staff mode!"));
            event.setCancelled(true);
        }
    }
}
