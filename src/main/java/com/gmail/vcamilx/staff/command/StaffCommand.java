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
public class StaffCommand implements CommandExecutor {

    private Staff staff;
    private StaffManager staffManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.color(
                    staff.getConfig().getString("messages.other.noConsole")));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staff.mode")) {
            player.sendMessage(ChatUtil.color(
                    staff.getConfig().getString("messages.other.noPermission")));
            return true;
        }

        if (args.length >= 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                staffManager.setStaff(target);
                return true;
            }
        }

        staffManager.setStaff(player);
        return false;
    }
}
