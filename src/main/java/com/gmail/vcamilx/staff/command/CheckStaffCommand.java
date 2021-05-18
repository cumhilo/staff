package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffManager;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@InjectAll
public class CheckStaffCommand implements CommandExecutor {

    private Staff staff;
    private StaffManager staffManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            checkStaffMode(player, target, args);
        }

        checkStaffMode(player, player, args);
        return false;
    }

    private void checkStaffMode(Player player, Player target, String[] args) {
        if (!player.hasPermission("staff.check")) {
            player.sendMessage(ChatUtil.color(
                staff.getConfig().getString("messages.other.noPermission")));
        }

        if (args.length != 1) {
            if (!staffManager.isStaffMode(player)) {
                player.sendMessage(ChatUtil.color("&c" + player.getName() + " it's not in staff mode."));
                return;
            }

            player.sendMessage(ChatUtil.color("&a" + player.getName() + " it's in staff mode."));
            return;
        }

        if (target != null) {
            if (!staffManager.isStaffMode(target)) {
                player.sendMessage(ChatUtil.color("&c" + target.getName() + " it's not in staff mode."));
                return;
            }

            player.sendMessage(ChatUtil.color("&a" + target.getName() + " it's in staff mode."));
            return;
        }

        player.sendMessage(ChatUtil.color("&c" + args[0] + " is currently offline."));
    }
}
