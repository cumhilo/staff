package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.inventory.StaffInventory;
import com.gmail.vcamilx.staff.util.cache.implemenatation.ManagerStorage;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffManager {

    private static final List<UUID> staffChat = new ArrayList<>();
    private static final ManagerStorage managerStorage = new ManagerStorage();
    private final StaffInventory staffInventory = new StaffInventory();

    @Inject
    private Staff staff;

    public void setStaff(Player player) {
        if (!isStaffMode(player)) {
            managerStorage.add(player.getUniqueId(), player.getInventory().getContents());
            player.getInventory().clear();
            staffInventory.inventory(player);

            player.setGameMode(GameMode.CREATIVE);
            setVanish(player);

            player.sendTitle(
                    ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.title")),
                    ChatUtil.color(staff.getConfig().getString("messages.staff.join.title.subtitle")),
                    staff.getConfig().getInt("messages.staff.join.title.fadeIn"),
                    staff.getConfig().getInt("messages.staff.join.title.stay"),
                    staff.getConfig().getInt("messages.staff.join.title.fadeOut"));
            player.sendMessage(
                    ChatUtil.color(staff.getConfig().getString("messages.staff.join.chat")));
            return;
        }

        managerStorage.find(player.getUniqueId()).ifPresent(itemStacks -> {
            player.getInventory().setContents(managerStorage.getValue(player.getUniqueId()));
            managerStorage.remove(player.getUniqueId());
        });

        player.setGameMode(GameMode.SURVIVAL);
        setVanish(player);

        player.sendTitle(
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.title")),
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.title.subtitle")),
                staff.getConfig().getInt("messages.staff.leave.title.fadeIn"),
                staff.getConfig().getInt("messages.staff.leave.title.stay"),
                staff.getConfig().getInt("messages.staff.leave.title.fadeOut"));
        player.sendMessage(
                ChatUtil.color(staff.getConfig().getString("messages.staff.leave.chat")));
    }

    private void setVanish(Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (!players.hasPermission("staff.mode") && players.canSee(player)) {
                players.hidePlayer(staff, player);
                return;
            }
            players.showPlayer(staff, player);
        }
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

    public boolean isStaffChat(Player player) {
        return staffChat.contains(player.getUniqueId());
    }

    public boolean isStaffMode(Player player) {
        return getManagerStorage().exists(player.getUniqueId());
    }

    public ManagerStorage getManagerStorage() {
        return managerStorage;
    }
}
