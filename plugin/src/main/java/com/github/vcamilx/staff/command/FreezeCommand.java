package com.github.vcamilx.staff.command;

import com.github.vcamilx.staff.manager.mode.FreezeManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

public class FreezeCommand implements CommandClass {

    @Inject
    private FreezeManager freezeManager;

    @Command(names = {"freeze", "ss"}, permission = "staff.*")
    public boolean onFreezePlayer(
            @Sender Player player,
            @Named("target") Player target) {

        freezeManager.setFrozen(player, target);

        return true;
    }
}
