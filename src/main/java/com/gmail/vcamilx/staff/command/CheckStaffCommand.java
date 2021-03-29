package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.staff.StaffEntity;
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
            Player target = Bukkit.getPlayer(args[0]);
            StaffEntity staffEntity = new StaffEntity(target);
            if (target != null && sender.hasPermission("staff.check")) {
                if (!staffEntity.isStaffMode()) {
                    sender.sendMessage(ChatUtil.translate("&e" + target.getName() + " it's not in staff mode."));
                    return true;
                }
                sender.sendMessage(ChatUtil.translate("&e" + target.getName() + " it's in staff mode."));
                return true;
            }

            sender.sendMessage(ChatUtil.translate("&c" + args[0] + " is currently offline."));
        }

        return false;
    }
}
