package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@InjectAll
public class InventorySeeCommand implements CommandExecutor {

    private Staff staff;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.color(
                    staff.getConfig().getString("messages.other.noConsole")));
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(ChatUtil.color("&cUsage: " + label + " <player>"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target != null && player.hasPermission("staff.inventory")) openPlayerInventory(player, target);
        return false;
    }

    private void openPlayerInventory(Player sender, Player player) {
        Inventory inventory = player.getInventory();
        sender.openInventory(inventory);
    }
}
