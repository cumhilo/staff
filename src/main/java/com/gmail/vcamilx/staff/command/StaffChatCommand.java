package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffMode;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class StaffChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.translate(Staff.getPlugin().getConfig().getString("messages.noConsole")));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staff.chat")) {
            player.sendMessage(ChatUtil.translate(Staff.getPlugin().getConfig().getString("messages.noPermission")));
            return true;
        }

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                StaffMode.setStaffChat(target);
                return true;
            }
        }

        StaffMode.setStaffChat(player);
        return false;
    }
}