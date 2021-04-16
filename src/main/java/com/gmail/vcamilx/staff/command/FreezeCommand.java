package com.gmail.vcamilx.staff.command;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.staff.FreezeManager;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@InjectAll
public class FreezeCommand implements CommandExecutor {

    private FreezeManager freezeManager;
    private Staff staff;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length != 1) return true;

        Player target = Bukkit.getPlayer(args[0]);

        if (target != null) {
            freezeManager.setFrozenState(target, player);
        }

        return false;
    }
}
