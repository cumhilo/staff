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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@InjectAll
public class StaffInteractEntityEvent implements Listener {

    private StaffManager staffManager;
    private FreezeManager freezeManager;

    @EventHandler
    public void interaction(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Player target = (Player) event.getRightClicked();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!staffManager.isStaffMode(player)) return;
        if (!(event.getRightClicked() instanceof Player)) return;

        if (itemInHand.getType() == Material.ICE && !staffManager.isStaffMode(target)) {
            freezeManager.setFrozenState((Player) target, player);
        }

        if (itemInHand.getType() == Material.BOOK) {
            openPlayerInventory(player, (Player) target);
        }

    }

    private void openPlayerInventory(Player sender, Player target) {
        Inventory inventory = target.getInventory();
        sender.openInventory(inventory);
    }
}
