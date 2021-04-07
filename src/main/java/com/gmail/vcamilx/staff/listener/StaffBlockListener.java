package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.inject.Inject;
import javax.inject.Named;

public class StaffBlockListener implements Listener {

    @Inject
    @Named("staff-manager")
    private Manager manager;

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (manager.isStaffMode(player)) {
            player.sendMessage(ChatUtil.color("&cYou cannot place bocks when you are in staff mode!"));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (manager.isStaffMode(player)) {
            player.sendMessage(ChatUtil.color("&cYou cannot break bocks when you are in staff mode!"));
            event.setCancelled(true);
        }
    }
}
