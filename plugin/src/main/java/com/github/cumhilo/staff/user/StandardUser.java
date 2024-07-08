package com.github.cumhilo.staff.user;

import com.github.cumhilo.staff.user.history.Sanctions;

import java.util.UUID;

public class StandardUser
        implements User {

    private UUID uuid;
    private Sanctions sanctions;

    @Override
    public UUID uuid() {
        return uuid;
    }

    @Override
    public Sanctions sanctions() {
        return sanctions;
    }
}
