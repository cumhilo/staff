package com.github.vcamilx.staff.command.staff;

import com.github.vcamilx.staff.manager.mode.StaffManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.annotated.annotation.SubCommandClasses;
import me.fixeddev.commandflow.bukkit.annotation.PlayerOrSource;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

@Command(names = {"staff", "mod"}, permission = "staff.*")
@SubCommandClasses({
        StaffCommand.class,
        StaffCheckCommand.class
})
public class StaffCommand implements CommandClass {

    @Inject
    private StaffManager staffManager;

    @Command(names = "")
    public boolean onPerformCommand(
            @Sender Player player,
            @PlayerOrSource @Named("target") Player target) {

        if (target != null) {
            staffManager.setStaff(target);
            return true;
        }

        staffManager.setStaff(player);

        return true;
    }
}
