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

    public String getRemainingTimeFormatted() {
        long remainingTime = getRemainingTime();
        long seconds = remainingTime / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        return days + "d " + hours % 24 + "h " + minutes % 60 + "m " + seconds % 60 + "s";
    }

    public void update() {
        this.now = Instant.now();
    }
}
