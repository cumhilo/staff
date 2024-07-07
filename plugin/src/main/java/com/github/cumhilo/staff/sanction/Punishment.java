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

    boolean isActive();

    void setIssuer(UUID issuer);

    void setReason(String reason);

    void setDate(Instant date);

    void setActive(boolean active);
}
