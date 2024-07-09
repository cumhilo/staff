package com.github.cumhilo.staff.user;

import com.github.cumhilo.staff.user.history.Sanctions;
import com.github.cumhilo.staff.user.registry.UserRegistry;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface User {

    UUID uuid();

    Sanctions sanctions();

    static UserRegistry registry() {
        return UserRegistry.get();
    }

    // i need to change this method later, handling the exceptio here isn't my favorite, also i'd like to
    // delegate the exception handling to the caller
    static User of(Player player) {
        return registry().getUser(player).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
