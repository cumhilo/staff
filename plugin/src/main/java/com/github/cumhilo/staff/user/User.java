package com.github.cumhilo.staff.user;

import com.github.cumhilo.staff.user.history.PunishmentHistory;
import com.github.cumhilo.staff.user.registry.UserRegistry;

import java.util.UUID;

public interface User {

    UUID uuid();

    PunishmentHistory punishments();

    static UserRegistry registry() {
        return UserRegistry.get();
    }
}
