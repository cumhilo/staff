package com.gmail.vcamilx.staff.util.chat;

import org.bukkit.ChatColor;

public class ChatUtil {
    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
