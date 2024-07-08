package com.github.cumhilo.staff.sanction;

import java.time.Duration;

public interface TemporaryPunishment
        extends Punishment {

    Duration duration();

    TemporaryPunishment setDuration(Duration duration);
}
