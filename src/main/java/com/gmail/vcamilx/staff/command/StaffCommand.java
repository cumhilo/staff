package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.StaffEntity;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.translate("&cNo console command."));
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staff.mode")) {
            ChatUtil.translate(Staff.plugin.getConfig().getString("messages.noPermission"));
            return true;
        }

        if (args.length != 0) {
            Player target = Bukkit.getPlayer(args[0]);
            setStaff(target);
            return true;
        }

        setStaff(player);
        return false;
    }

    private void setStaff(Player player) {
        StaffEntity staffEntity = new StaffEntity(player);
        if (!staffEntity.isStaffMode()) {
            staffEntity.setStaffMode(true);
            player.sendMessage(ChatUtil.translate("&aNow you're in staff-mode!"));
            return;
        }
        player.sendMessage(ChatUtil.translate("&cYou aren't in personal mode now!"));
        staffEntity.setStaffMode(false);
    }
}
