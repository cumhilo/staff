package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.Manager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {
    private final Manager manager = new Manager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.color(
                    Staff.getPlugin().getConfig().getString("messages.other.noConsole")));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staff.mode")) {
            player.sendMessage(ChatUtil.color(
                    Staff.getPlugin().getConfig().getString("messages.other.noPermission")));
            return true;
        }

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                if (!manager.isStaffMode(target)) {
                    manager.setStaff(target);
                    return true;
                }

                manager.disableStaff(target);
                return true;
            }
        }
        if (!manager.isStaffMode(player)) {
            manager.setStaff(player);
            return true;
        }

        manager.disableStaff(player);
        return false;
    }
}
