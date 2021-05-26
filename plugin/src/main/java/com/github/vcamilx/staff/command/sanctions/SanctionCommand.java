package com.github.vcamilx.staff.command.sanctions;

import com.github.vcamilx.staff.manager.sanctions.SanctionManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

@Command(names = {"sanction", "sanctions"}, permission = "staff.*")
public class SanctionCommand implements CommandClass {

    @Inject
    private SanctionManager sanctionManager;

    @Command(names = "check")
    public boolean performGetCommand(
            @Sender Player player,
            @Named("target") Player target) {

        sanctionManager.getSanctions(target);

        return true;
    }
}
