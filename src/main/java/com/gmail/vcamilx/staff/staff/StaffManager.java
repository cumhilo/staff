package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffManager {
    public static Map<UUID, Player> staffMap = new HashMap<>();
    public static Map<UUID, Player> staffChat = new HashMap<>();

    public static void setStaff(Player player) {
        if (!isStaffMode(player)) {
            staffMap.put(player.getUniqueId(), player);
            player.setAllowFlight(true);
            player.sendMessage(ChatUtil.translate("&aNow you're in staff-mode!"));
        }
    }

    public static void disableStaff(Player player) {
        if (isStaffMode(player)) {
            staffMap.remove(player.getUniqueId());
            player.setAllowFlight(false);
            player.sendMessage(ChatUtil.translate("&cYou aren't in staff mode now!"));
        }
    }

    public static void setStaffChat(Player player) {
        if (!isStaffChat(player)) {
            staffChat.put(player.getUniqueId(), player);
            player.sendMessage(ChatUtil.translate("&bNow you're in staff-chat!"));
            return;
        }

        staffChat.remove(player.getUniqueId());
        player.sendMessage(ChatUtil.translate("&cYou aren't in staff chat now!"));
    }

    public static boolean isStaffMode(Player player) {
        return staffMap.containsKey(player.getUniqueId());
    }

    public static boolean isStaffChat(Player player) {
        return staffChat.containsKey(player.getUniqueId());
    }
}
