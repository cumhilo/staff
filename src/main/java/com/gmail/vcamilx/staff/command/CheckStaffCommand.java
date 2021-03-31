package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffMode;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckStaffCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            if (sender.hasPermission("staff.check")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (!StaffMode.isStaffMode(target)) {
                        sender.sendMessage(ChatUtil.translate("&c" + target.getName() + " it's not in staff mode."));
                        return true;
                    }
                    sender.sendMessage(ChatUtil.translate("&a" + target.getName() + " it's in staff mode."));
                    return true;
                }

                sender.sendMessage(ChatUtil.translate("&c" + args[0] + " is currently offline."));
                return true;
            }
            
            sender.sendMessage(ChatUtil.translate(
                    Staff.getPlugin().getConfig().getString("messages.other.noPermission")));
        }
        return false;
    }
}
