package com.github.vcamilx.staff.listener.user;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import javax.inject.Inject;

public class FreezeBreakBlockListener implements Listener {

    @Inject
    private FreezeManager freezeManager;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!freezeManager.isFrozen(player)) return;

        player.sendMessage(ChatUtil.color("&cYou cannot break blocks when you are frozen!"));
        event.setCancelled(true);
    }
}