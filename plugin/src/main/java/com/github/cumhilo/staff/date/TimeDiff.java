package com.github.cumhilo.staff.date;

import java.time.Duration;
import java.time.Instant;

public class TimeDiff {

    private final Instant start;
    private final Duration duration;

    private Instant now;

    public TimeDiff(Instant start, Duration duration) {
        this.start = start;
        this.duration = duration;
        this.now = Instant.now();
    }

    public boolean isOver() {
        return now.toEpochMilli() - start.toEpochMilli() >= duration.toMillis();
    }

    public long getRemainingTime() {
        return duration.toMillis() - (now.toEpochMilli() - start.toEpochMilli());
    }

    public long getElapsedTime() {
        return now.toEpochMilli() - start.toEpochMilli();
    }

    public String getRemainingTimeFormatted() {
        return TimeFormat.toSimplifiedHumanTime(getRemainingTime());
    }

    public String getElapsedTimeFormatted() {
        return TimeFormat.toSimplifiedHumanTime(getElapsedTime());
    }

    public void update() {
        this.now = Instant.now();
    }
}
