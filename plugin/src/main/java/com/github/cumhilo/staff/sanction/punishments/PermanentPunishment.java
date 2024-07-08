package com.github.cumhilo.staff.sanction.punishments;

import com.github.cumhilo.staff.sanction.Punishment;
import com.github.cumhilo.staff.sanction.PunishmentType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.UUID;

public class PermanentPunishment
        implements Punishment {

    private UUID issuer;
    private String reason;
    private Instant date;
    private PunishmentType type;
    private boolean active;

    public PermanentPunishment() {}

    private PermanentPunishment(@NotNull UUID issuer, @Nullable String reason, @NotNull Instant date, @NotNull PunishmentType type, boolean active) {
        this.issuer = issuer;
        this.reason = reason;
        this.date = date;
        this.type = type;
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
}
