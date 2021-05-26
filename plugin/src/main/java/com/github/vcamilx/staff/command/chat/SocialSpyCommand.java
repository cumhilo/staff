package com.github.vcamilx.staff.command.chat;

import com.github.vcamilx.staff.manager.mode.SocialSpyManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

public class SocialSpyCommand implements CommandClass {

    @Inject
    private SocialSpyManager socialSpyManager;

    @Command(names = {"socialspy", "sp"}, permission = "staff.*")
    public boolean performCommand(@Sender Player player) {

        if (!socialSpyManager.isSocialSpy(player)) {
            socialSpyManager.setSocialSpy(player, true);
            return true;
        }

        socialSpyManager.setSocialSpy(player, false);
        return true;
    }
}
