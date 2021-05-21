package com.github.vcamilx.staff.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

public class InventorySeeCommand implements CommandClass {

    @Command(names = {"invsee", "inventorysee", "inspect"}, permission = "staff.*")
    public boolean performCommand(
            @Sender Player player,
            @Named("target") Player target) {

        player.openInventory(target.getInventory());

        return true;
    }
}
