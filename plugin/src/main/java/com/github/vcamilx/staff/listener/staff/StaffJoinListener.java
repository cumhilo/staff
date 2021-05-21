package com.github.vcamilx.staff.listener.staff;

import com.github.vcamilx.staff.manager.database.MongoManager;
import com.github.vcamilx.staff.manager.mode.StaffManager;
import me.yushust.inject.InjectAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@InjectAll
public class StaffJoinListener implements Listener {

    private StaffManager staffManager;
    private MongoManager mongoManager;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staff.mode")) {
            staffManager.setStaff(player);
            mongoManager.connection();
        }
    }
}