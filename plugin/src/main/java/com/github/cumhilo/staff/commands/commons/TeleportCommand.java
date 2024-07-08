package com.github.cumhilo.staff.commands.commons;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.incendo.cloud.annotations.Argument;
import org.incendo.cloud.annotations.Command;
import org.incendo.cloud.annotations.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.cumhilo.staff.StaffPermissions.STAFF_TELEPORT;
import static com.github.cumhilo.staff.StaffPermissions.STAFF_TELEPORT_POSITION;
import static com.github.cumhilo.staff.StaffPermissions.STAFF_TELEPORT_ALL;

public class TeleportCommand {

    @Command(value = "tp|teleport <requester> [target]")
    @Permission(STAFF_TELEPORT)
    public void teleport(Player player,
                         @Argument(value = "requester", description = "Player to teleport") Player requester,
                         @Argument(value = "target", description = "Player to teleport to") @Nullable Player target) {
        if (target == null) {
            player.teleport(requester);
        } else {
            requester.teleport(target);
        }
    }

    @Command(value = "tp|teleport <location> [target]")
    @Permission(STAFF_TELEPORT_POSITION)
    public void teleport(Player player,
                         @Argument(value = "location", description = "Location to teleport") @NotNull Location location,
                         @Argument(value = "target", description = "Player to teleport") @Nullable Player target) {
        if (target == null) {
            player.teleport(location);
        } else {
            target.teleport(location);
        }
    }


    @Command(value = "tpall")
    @Permission(STAFF_TELEPORT_ALL)
    public void teleportAll(Player player) {
        player.getServer()
                .getOnlinePlayers()
                .forEach(target -> target.teleport(player));
    }
}
