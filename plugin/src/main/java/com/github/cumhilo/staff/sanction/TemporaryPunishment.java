package com.github.cumhilo.staff.sanction;

import java.time.Duration;

public interface TemporaryPunishment
        extends Punishment {

    Duration duration();

    void setDuration(Duration duration);
}
