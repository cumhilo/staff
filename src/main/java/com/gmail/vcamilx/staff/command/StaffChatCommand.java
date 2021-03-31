package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.translate(Staff.getPlugin().getConfig().getString("messages.other.noConsole")));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staff.chat")) {
            player.sendMessage(ChatUtil.translate(
                    Staff.getPlugin().getConfig().getString("messages.other.noPermission")));
            return true;
        }

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                StaffManager.setStaffChat(target);
                return true;
            }
        }

        StaffManager.setStaffChat(player);
        return false;
    }
}
