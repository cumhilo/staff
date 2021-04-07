package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.inventory.StaffInventory;
import com.gmail.vcamilx.staff.util.cache.implemenatation.ManagerStorage;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@InjectAll
public class Manager {

    private Staff staff;
    private ManagerStorage playerCache;
    private final StaffInventory staffInventory = new StaffInventory();
    private static final List<UUID> staffChat = new ArrayList<>();

    public void setStaff(Player player) {
        // Inventory
        playerCache.add(player.getUniqueId(), player.getInventory().getContents());
        player.getInventory().clear();
        staffInventory.inventory(player);

        player.setGameMode(GameMode.CREATIVE);

        // Vanish
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (!players.hasPermission("staff.mode")) {
                players.hidePlayer(staff, player);
            }
        }
        // Messages
        player.sendTitle(
                ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.title")),
                ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.subtitle")),
                staff.getConfig().getInt("messages.staff.join.title.fadeIn"),
                staff.getConfig().getInt("messages.staff.join.title.stay"),
                staff.getConfig().getInt("messages.staff.join.title.fadeOut"));
        player.sendMessage(
                ChatUtil.color(staff.getConfig().getString("messages.staff.join.chat")));
    }

    public void disableStaff(Player player) {
        playerCache.find(player.getUniqueId()).ifPresent(itemStacks -> {
            player.getInventory().setContents(playerCache.getValue(player.getUniqueId()));
            playerCache.remove(player.getUniqueId());
        });

        player.setGameMode(GameMode.SURVIVAL);

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (!players.canSee(player)) {
                players.showPlayer(staff, player);
            }
        }

        player.sendTitle(
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.title")),
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.subtitle")),
                staff.getConfig().getInt("messages.staff.leave.title.fadeIn"),
                staff.getConfig().getInt("messages.staff.leave.title.stay"),
                staff.getConfig().getInt("messages.staff.leave.title.fadeOut"));
        player.sendMessage(
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.chat")));

    }

    public void setStaffChat(Player player) {
        if (!isStaffChat(player)) {
            staffChat.add(player.getUniqueId());
            player.sendMessage(ChatUtil.color("&bNow you're in staff-chat!"));
            return;
        }

        staffChat.remove(player.getUniqueId());
        player.sendMessage(ChatUtil.color("&cYou aren't in staff chat now!"));
    }

    public boolean isStaffMode(Player player) {
        return playerCache.exists(player.getUniqueId());
    }

    public boolean isStaffChat(Player player) {
        return staffChat.contains(player.getUniqueId());
    }
}
