package com.github.vcamilx.staff.command.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

public class StaffCheckCommand implements CommandClass {

    @Inject
    private StaffManager staffManager;

    @Command(names = {"check", "verify"}, desc = "Verify if a staff is in staff mode")
    public boolean performCommand(
            @Sender Player player,
            @Named("target") Player target) {

        if (staffManager.isStaffMode(target)) {
            player.sendMessage(ChatUtil.color("&a" + target.getName() + " it's in staff mode."));
            return true;
        }

        player.sendMessage(ChatUtil.color("&c" + target.getName() + " it's not in staff mode."));
        return true;
    }
}
