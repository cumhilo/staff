package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import com.gmail.vcamilx.staff.staff.StaffManager;
import me.yushust.inject.InjectAll;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

@InjectAll
public class StaffInteractListener implements Listener {

    private StaffManager staffManager;
    private FreezeManager freezeManager;

    @EventHandler
    public void interaction(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity target = event.getRightClicked();


        if (!staffManager.isStaffMode(player)) return;
        if (!(target instanceof Player)) return;

        if (player.getInventory().getItemInMainHand().getType() == Material.ICE) {
            if (!staffManager.isStaffMode(target)) {
                freezeManager.setFrozenState((Player) target, player);
            }
        }
    }
}
