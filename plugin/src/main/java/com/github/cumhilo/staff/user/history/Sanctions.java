package com.github.cumhilo.staff.user.history;

import com.github.cumhilo.staff.sanction.Punishment;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Set;

public class Sanctions {

    private Set<Punishment> punishments;
    private Set<Punishment> activePunishments;

    public Set<Punishment> punishments() {
        return punishments;
    }

    public Set<Punishment> activePunishments() {
        return activePunishments;
    }

    public void addPunishment(@NotNull Punishment punishment) {
        punishments.add(punishment);
        activePunishments.add(punishment);
    }

    public void remove(Punishment punishment) {
        activePunishments.remove(punishment);
    }

    private boolean validate(@NotNull Punishment punishment) {
        Objects.requireNonNull(punishment);

        if (punishment.issuer() == null) {
            return false;
        }

        if (punishment.date() == null) {
            return false;
        }

        return punishment.type() != null;
    }
}
