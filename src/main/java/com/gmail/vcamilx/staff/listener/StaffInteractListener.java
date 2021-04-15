package com.gmail.vcamilx.staff.listener;

import com.gmail.vcamilx.staff.staff.Manager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

@InjectAll
public class StaffInteractListener implements Listener {

    private Manager manager;

    @EventHandler
    public void interaction(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Player target = (Player) event.getRightClicked();


        if (!manager.isStaffMode(player)) return;

        if (!(target instanceof Player)) return;

        if (player.getInventory().getItemInMainHand().getType() == Material.ICE) {
            if (!manager.isStaffMode(target)) {
                player.sendMessage(ChatUtil.color("&cTest"));
                target.sendMessage("Test");
            }
        }
    }
}
