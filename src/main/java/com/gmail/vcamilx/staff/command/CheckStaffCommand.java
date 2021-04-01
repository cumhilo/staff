package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.Manager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckStaffCommand implements CommandExecutor {
    private final Manager manager = new Manager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            if (sender.hasPermission("staff.check")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (!manager.isStaffMode(target)) {
                        sender.sendMessage(ChatUtil.color("&c" + target.getName() + " it's not in staff mode."));
                        return true;
                    }
                    sender.sendMessage(ChatUtil.color("&a" + target.getName() + " it's in staff mode."));
                    return true;
                }

                sender.sendMessage(ChatUtil.color("&c" + args[0] + " is currently offline."));
                return true;
            }
            
            sender.sendMessage(ChatUtil.color(
                    Staff.getPlugin().getConfig().getString("messages.other.noPermission")));
        }
        return false;
    }
}
