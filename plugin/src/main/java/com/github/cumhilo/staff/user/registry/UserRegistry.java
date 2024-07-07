package com.github.cumhilo.staff.user.registry;

import com.github.cumhilo.staff.user.User;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRegistry {

    private final Map<Player, User> playerAsUser = new ConcurrentHashMap<>();
    private final Map<User, Player> userAsPlayer = new ConcurrentHashMap<>();

    private static final class InstanceHolder {
        private static final UserRegistry instance = new UserRegistry();
    }

    public static UserRegistry get() {
        return InstanceHolder.instance;
    }
}