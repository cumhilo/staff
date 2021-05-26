package com.github.vcamilx.staff.command.vanish;

import com.github.vcamilx.staff.manager.mode.VanishManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

public class VanishCommand implements CommandClass {

    @Inject
    private VanishManager vanishManager;

    public boolean performCommand(@Sender Player player) {
        vanishManager.setVanish(player);

        return true;
    }
}
