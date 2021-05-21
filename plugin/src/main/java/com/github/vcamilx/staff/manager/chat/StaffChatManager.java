package com.github.vcamilx.staff.manager.chat;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.util.chat.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import javax.inject.Inject;

public class StaffChatManager {

    @Inject
    private Staff staff;

    /**
     * Here, we will find a method which will allow us to add a metadata to the player without the need to repeat code
     * unnecessarily, besides allowing us to have everything more organized.
     *
     * @param player the player to which the metadata is to be applied
     */

    public void setChatMode(Player player) {
        if (!isChatMode(player)) {
            player.setMetadata("staff-chat", new FixedMetadataValue(staff, true));
            player.sendMessage(ChatUtil.color("&bNow you're in staff-chat!"));
            return;
        }

        player.removeMetadata("staff-chat", staff);
        player.sendMessage(ChatUtil.color("&cYou aren't in staff chat now!"));
    }

    /**
     * @param player the player we want to check if he is in ChatMode
     * @return true or false, depending on the player's metadata
     */

    public boolean isChatMode(Player player) {
        return player.hasMetadata("staff-chat");
    }
}
