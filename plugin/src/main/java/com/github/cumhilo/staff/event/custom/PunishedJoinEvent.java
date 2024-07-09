package com.github.cumhilo.staff.event.custom;

import com.github.cumhilo.staff.sanction.Punishment;
import com.github.cumhilo.staff.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class PunishedJoinEvent
        extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final User user;
    private final Player player;
    private final Set<Punishment> punishments;

    public PunishedJoinEvent(User user, Player player, Set<Punishment> punishments) {
        this.user = user;
        this.player = player;
        this.punishments = punishments;
    }

    public User user() {
        return user;
    }

    public Player player() {
        return player;
    }

    public Set<Punishment> punishments() {
        return punishments;
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
