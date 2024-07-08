package com.github.cumhilo.staff.sanction.punishments;

import com.github.cumhilo.staff.sanction.Punishment;
import com.github.cumhilo.staff.sanction.PunishmentType;
import com.github.cumhilo.staff.sanction.TemporaryPunishment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

// i should modify this and do an unique impl and create a enum for types
// load all the active punishments in the suer profiel and checking it one time while initializing the user
// and checking it again when the user is trying to connect, or chatting, idk
public class ExpirablePunishment
        implements TemporaryPunishment {

    private UUID issuer;
    private String reason;
    private Instant date;
    private PunishmentType type;
    private Duration duration;
    private boolean active;

    public ExpirablePunishment() {}

    private ExpirablePunishment(@NotNull UUID issuer, @Nullable String reason, @NotNull Instant date, @NotNull PunishmentType type, @NotNull Duration duration, boolean active) {
        this.issuer = issuer;
        this.reason = reason;
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.active = active;
    }

    @Override
    public UUID issuer() {
        return issuer;
    }

    @Override
    public String reason() {
        return reason;
    }

    @Override
    public Instant date() {
        return date;
    }

    @Override
    public PunishmentType type() {
        return type;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public Duration duration() {
        return duration;
    }

    @Override
    public Punishment setIssuer(UUID issuer) {
        this.issuer = issuer;
        return this;
    }

    @Override
    public Punishment setReason(String reason) {
        this.reason = reason;
        return this;
    }

    @Override
    public Punishment setDate(Instant date) {
        this.date = date;
        return this;
    }

    @Override
    public Punishment setType(PunishmentType type) {
        this.type = type;
        return this;
    }

    @Override
    public Punishment setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public TemporaryPunishment setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }
}
