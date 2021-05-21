package com.github.vcamilx.staff.command.staff;

import com.github.vcamilx.staff.manager.chat.StaffChatManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.PlayerOrSource;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

public class StaffChatCommand implements CommandClass {

    @Inject
    private StaffChatManager staffChatManager;

    @Command(names = {"chat", "c"}, desc = "Staff chat command")
    public boolean performCommand(
            @Sender Player player,
            @PlayerOrSource @Named("target") Player target) {

        staffChatManager.setChatMode(target);

        return true;
    }
}
