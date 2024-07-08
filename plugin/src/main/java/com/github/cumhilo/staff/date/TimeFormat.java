package com.github.cumhilo.staff.date;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class TimeFormat {

    private static final StringJoiner JOINER = new StringJoiner(" ");

    public static String toSimplifiedHumanTime(long time) {
        long seconds = time / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (days > 0) {
            JOINER.add(days + "d");
        }

        if (hours > 0) {
            JOINER.add(hours % 24 + "h");
        }

        if (minutes > 0) {
            JOINER.add(minutes % 60 + "m");
        }

        if (seconds > 0 || JOINER.length() == 0) {
            JOINER.add(seconds % 60 + "s");
        }

        return JOINER.toString();
    }

    public static String toHumanTime(long time) {
        long seconds = time / 1000;

        int unitValue = Math.toIntExact(seconds / TimeUnit.DAYS.toSeconds(7));
        if (unitValue > 0) {
            seconds %= TimeUnit.DAYS.toSeconds(7);

            String unit;

            if (unitValue == 1) {
                unit = "week";
            } else {
                unit = "Weeks";
            }

            JOINER.add(unitValue + " " + unit);
        }

        unitValue = Math.toIntExact(seconds / TimeUnit.DAYS.toSeconds(1));
        if (unitValue > 0) {
            seconds %= TimeUnit.DAYS.toSeconds(1);

            String unit;

            if (unitValue == 1) {
                unit = "day";
            } else {
                unit = "dayS";
            }

            JOINER.add(unitValue + " " + unit);
        }

        unitValue = Math.toIntExact(seconds / TimeUnit.HOURS.toSeconds(1));
        if (unitValue > 0) {
            seconds %= TimeUnit.HOURS.toSeconds(1);
            String unit;

            if (unitValue == 1) {
                unit = "hour";
            } else {
                unit = "hours";
            }

            JOINER.add(unitValue + " " + unit);
        }

        unitValue = Math.toIntExact(seconds / TimeUnit.MINUTES.toSeconds(1));
        if (unitValue > 0) {
            seconds %= TimeUnit.MINUTES.toSeconds(1);
            String unit;

            if (unitValue == 1) {
                unit = "minute";
            } else {
                unit = "minutes";
            }

            JOINER.add(unitValue + " " + unit);
        }

        if (seconds > 0 || JOINER.length() == 0) {
            String unit;

            if (seconds == 1) {
                unit = "second";
            } else {
                unit = "seconds";
            }

            JOINER.add(seconds + " " + unit);
        }

        return JOINER.toString();
    }
}
