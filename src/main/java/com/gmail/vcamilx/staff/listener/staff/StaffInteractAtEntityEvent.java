package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.staff.FreezeManager;
import com.gmail.vcamilx.staff.staff.StaffManager;
import me.yushust.inject.InjectAll;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@InjectAll
public class StaffInteractAtEntityEvent implements Listener {

    private StaffManager staffManager;
    private FreezeManager freezeManager;

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!staffManager.isStaffMode(player)) return;
        if (!(event.getRightClicked() instanceof Player)) return;
        if (event.getHand() != EquipmentSlot.HAND) return;

        Player target = (Player) event.getRightClicked();

        if (itemInHand.getType() == Material.ICE && !staffManager.isStaffMode(target)) {
            freezeManager.setFrozenState(target, player);
        }

        if (itemInHand.getType() == Material.BOOK) {
            openPlayerInventory(player, target);
        }
    }

    private void openPlayerInventory(Player sender, Player target) {
        Inventory inventory = target.getInventory();
        sender.openInventory(inventory);
    }
}
