package com.github.cumhilo.staff.sanction;

import java.time.Instant;
import java.util.UUID;

public interface Punishment {

    /**
     * The player who issued the punishment
     *
     * @return the player
     */
    UUID issuer();

    /**
     * The reason for the punishment
     *
     * @return the reason
     */
    String reason();

    /**
     * The date of the punishment
     *
     * @return the date
     */
    Instant date();

    PunishmentType type();

    boolean isActive();

    Punishment setIssuer(UUID issuer);

    Punishment setReason(String reason);

    Punishment setDate(Instant date);

    Punishment setActive(boolean active);

    Punishment setType(PunishmentType type);
}
