package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Manager {
    private final Map<UUID, Player> staffMap = new HashMap<>();
    private final Map<UUID, Player> staffChat = new HashMap<>();
    private final Map<UUID, ItemStack[]> playerInventoryHashMap = new HashMap<>();

    public void setStaff(Player player) {
        if (!isStaffMode(player)) {
            staffMap.put(player.getUniqueId(), player);
            playerInventoryHashMap.put(player.getUniqueId(), player.getInventory().getContents());
            player.getInventory().clear();
            player.setGameMode(GameMode.CREATIVE);
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (!players.hasPermission("staff.mode")) {
                    players.hidePlayer(Staff.getPlugin(), player);
                }
            }

            player.sendTitle(
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.join.title.title")),
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.join.title.subtitle")),
                    Staff.getPlugin().getConfig().getInt("messages.staff.join.title.fadeIn"),
                    Staff.getPlugin().getConfig().getInt("messages.staff.join.title.stay"),
                    Staff.getPlugin().getConfig().getInt("messages.staff.join.title.fadeOut"));
            player.sendMessage(
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.join.chat")));
        }
    }

    public void disableStaff(Player player) {
        if (isStaffMode(player)) {
            staffMap.remove(player.getUniqueId());
            player.getInventory().setContents(playerInventoryHashMap.get(player.getUniqueId()));
            playerInventoryHashMap.remove(player.getUniqueId());
            player.setGameMode(GameMode.SURVIVAL);
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (!players.canSee(player)) {
                    players.showPlayer(Staff.getPlugin(), player);
                }
            }
            player.sendTitle(
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.leave.title.title")),
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.leave.title.subtitle")),
                    Staff.getPlugin().getConfig().getInt("messages.staff.leave.title.fadeIn"),
                    Staff.getPlugin().getConfig().getInt("messages.staff.leave.title.stay"),
                    Staff.getPlugin().getConfig().getInt("messages.staff.leave.title.fadeOut"));
            player.sendMessage(
                    ChatUtil.color(Staff.getPlugin().getConfig().getString("messages.staff.leave.chat")));
        }
    }

    public void setStaffChat(Player player) {
        if (!isStaffChat(player)) {
            staffChat.put(player.getUniqueId(), player);
            player.sendMessage(ChatUtil.color("&bNow you're in staff-chat!"));
            return;
        }

        staffChat.remove(player.getUniqueId());
        player.sendMessage(ChatUtil.color("&cYou aren't in staff chat now!"));
    }

    public boolean isStaffMode(Player player) {
        return staffMap.containsKey(player.getUniqueId());
    }

    public boolean isStaffChat(Player player) {
        return staffChat.containsKey(player.getUniqueId());
    }

}
