package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import javax.inject.Inject;

public class StaffBlockBreakListener implements Listener {

    @Inject
    private StaffManager staffManager;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (staffManager.isStaffMode(player)) {
            player.sendMessage(ChatUtil.color("&cYou cannot break blocks when you are in staff mode!"));
            event.setCancelled(true);
        }
    }
}