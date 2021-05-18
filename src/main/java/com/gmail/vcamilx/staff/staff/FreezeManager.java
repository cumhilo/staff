package com.gmail.vcamilx.staff.staff;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import javax.inject.Inject;

public class FreezeManager {

    @Inject
    private Staff staff;

    public void setFrozenState(Player player, Player freezer) {
        if (isFrozenState(player)) {
            player.setMetadata("freeze", new FixedMetadataValue(staff, true));

            staff.getConfig().getStringList("messages.freeze.target.freeze")
                .forEach(s -> player.sendMessage(ChatUtil.color(s)
                    .replace("%frozen%", player.getName())));

            staff.getConfig().getStringList("messages.freeze.staff.freeze")
                .forEach(s -> freezer.sendMessage(ChatUtil.color(s)
                    .replace("%frozen%", player.getName())
                    .replace("%staff%", freezer.getName())));

            return;
        }

        staff.getConfig().getStringList("messages.freeze.target.unfreeze")
            .forEach(s -> player.sendMessage(ChatUtil.color(s)
                .replace("%frozen%", player.getName())));


        staff.getConfig().getStringList("messages.freeze.staff.unfreeze")
            .forEach(s -> freezer.sendMessage(ChatUtil.color(s)
                .replace("%frozen%", player.getName())));

        player.removeMetadata("freeze", staff);
    }

    public boolean isFrozenState(Player player) {
        return player.hasMetadata("freeze");
    }
}
