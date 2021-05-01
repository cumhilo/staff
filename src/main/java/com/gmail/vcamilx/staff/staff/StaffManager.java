package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.inventory.StaffInventory;
import com.gmail.vcamilx.staff.util.cache.implemenatation.ManagerStorage;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import javax.inject.Inject;

public class StaffManager {


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
        Bukkit.getOnlinePlayers().forEach(player1 -> {
            if (!player1.hasPermission("staff.mode") && !player1.canSee(player)) {
                player1.showPlayer(staff, player);
                return;
            }

            player1.hidePlayer(staff, player);
        });
    }

    public void setStaffChat(Player player) {
        if (!isStaffChat(player)) {
            player.setMetadata("staff-chat", new FixedMetadataValue(staff, true));
            player.sendMessage(ChatUtil.color("&bNow you're in staff-chat!"));
            return;
        }

        player.removeMetadata("staff-chat", staff);
        player.sendMessage(ChatUtil.color("&cYou aren't in staff chat now!"));
    }

    public boolean isStaffChat(Player player) {
        return player.hasMetadata("staff-chat");
    }

    public boolean isStaffMode(Player player) {
        return getManagerStorage().exists(player.getUniqueId());
    }

    public ManagerStorage getManagerStorage() {
        return managerStorage;
    }
}
