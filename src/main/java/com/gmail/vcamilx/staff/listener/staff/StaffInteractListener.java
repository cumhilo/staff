package com.gmail.vcamilx.staff.listener.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import me.yushust.inject.InjectIgnore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@InjectAll
public class StaffInteractListener implements Listener {

    @InjectIgnore
    private final List<String> staffList = new ArrayList<>();

    private Staff staff;
    private StaffManager staffManager;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!staffManager.isStaffMode(player)) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)

            if (itemInHand.getType() == Material.PLAYER_HEAD) {
                Bukkit.getOnlinePlayers().forEach(player1 -> {
                    if (player1.hasPermission("staff") && !staffList.contains(player1.getName()))
                        staffList.add(player1.getName());

                    if (!player1.isOnline()) staffList.remove(player1.getName());
                });

                StringBuilder stringBuilder = new StringBuilder();

                staffList.forEach(s -> stringBuilder.append(s).append(", "));

                for (String message : staff.getConfig().getStringList("messages.staff.list")) {
                    player.sendMessage(ChatUtil.color(message)
                            .replaceAll("%staffs%", stringBuilder.toString()));
                }
            }

        event.setCancelled(true);
    }
}
