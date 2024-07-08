package com.github.cumhilo.staff.user;

import com.github.cumhilo.staff.user.history.Sanctions;
import com.github.cumhilo.staff.user.registry.UserRegistry;

import java.util.UUID;

public interface User {

    UUID uuid();

    Sanctions sanctions();

    static UserRegistry registry() {
        return UserRegistry.get();
    }
}
