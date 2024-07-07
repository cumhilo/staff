package com.github.cumhilo.staff.user;

import com.github.cumhilo.staff.user.history.PunishmentHistory;

import java.util.UUID;

public class DefaultUser
        implements User {

    private UUID uuid;
    private PunishmentHistory punishmentHistory;

    @Override
    public UUID uuid() {
        return uuid;
    }

    @Override
    public PunishmentHistory punishments() {
        return punishmentHistory;
    }
}
