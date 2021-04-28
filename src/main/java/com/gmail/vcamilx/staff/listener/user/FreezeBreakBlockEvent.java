package com.gmail.vcamilx.staff.listener.user;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import com.gmail.vcamilx.staff.staff.StaffManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import javax.inject.Inject;

public class FreezeBreakBlockEvent implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (freezeManager.isFrozenState(player)) return;

        player.sendMessage(ChatUtil.color("&cYou cannot break blocks when you are frozen!"));
        event.setCancelled(true);
    }
}

