package com.github.vcamilx.staff.manager.mode;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import javax.inject.Inject;

public class FreezeManager {

    @Inject
    private Staff staff;

    /**
     * Here, we will find a method which will allow us to add a metadata to the player without the need to repeat code
     * unnecessarily, besides allowing us to have everything more organized.
     *
     * @param player  the player to which the metadata is to be applied
     * @param freezer the one who executes the action of freezing the player
     */

    public void setFrozen(Player player, Player freezer) {
        if (!isFrozen(player)) {
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

    /**
     * @param player the player we want to check if he is Frozen
     * @return true or false, depending on the player's metadata
     */

    public boolean isFrozen(Player player) {
        return player.hasMetadata("freeze");
    }
}