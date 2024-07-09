package com.github.cumhilo.staff.event.custom.specific;

import com.github.cumhilo.staff.sanction.Punishment;
import com.github.cumhilo.staff.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BannedJoinEvent
        extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final User user;
    private final Player player;
    private final Punishment punishment;

    public BannedJoinEvent(User user, Player player, Punishment punishment) {
        this.user = user;
        this.player = player;
        this.punishment = punishment;
    }

    public User user() {
        return user;
    }

    public Player player() {
        return player;
    }

    public Punishment punishment() {
        return punishment;
    }

    @Contract(pure = true)
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }
}
