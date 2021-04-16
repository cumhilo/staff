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

            for (String freezeMessage : staff.getConfig().getStringList("messages.freeze.target.freeze")) {
                player.sendMessage(ChatUtil.color(freezeMessage)
                        .replaceAll("%frozen%", player.getName()));
            }

            for (String freezeMessage : staff.getConfig().getStringList("messages.freeze.staff.freeze")) {
                freezer.sendMessage(ChatUtil.color(freezeMessage)
                        .replaceAll("%frozen%", player.getName())
                        .replaceAll("%staff%", freezer.getName()));
            }

            return;
        }

        for (String freezeMessage : staff.getConfig().getStringList("messages.freeze.target.unfreeze")) {
            player.sendMessage(ChatUtil.color(freezeMessage)
                    .replaceAll("%frozen%", player.getName()));
        }

        for (String freezeMessage : staff.getConfig().getStringList("messages.freeze.staff.unfreeze")) {
            freezer.sendMessage(ChatUtil.color(freezeMessage)
                    .replaceAll("%frozen%", player.getName()));
        }

        player.removeMetadata("freeze", staff);
    }

    public boolean isFrozenState(Player player) {
        return !player.hasMetadata("freeze");
    }
}
