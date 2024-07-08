package com.github.cumhilo.staff.sanction;

import com.github.cumhilo.staff.user.User;

public class PunishmentHandler {

    public void execute(User user, Punishment punishment) {
        user.sanctions().addPunishment(punishment);
    }
}
