package com.github.cumhilo.staff.sanction;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents a punishment
 * <p>
 * A punishment is an action taken against a player for breaking the rules
 * of the server. It is issued by a player and has a reason and a date.
 * It can be active or inactive, it would be shown in the history, the active doesn't mean that the player is
 * currently being punished.
 */
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
