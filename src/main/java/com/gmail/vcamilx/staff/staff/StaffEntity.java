package com.gmail.vcamilx.staff.staff;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
@Setter
public class StaffEntity {
    private Player player;
    private boolean staffChat,
            staffMode,
            vanished;

    public StaffEntity(Player player) {
        this.player = player;
        this.staffChat = true;
        this.staffMode = true;
        this.vanished = true;
    }
}
