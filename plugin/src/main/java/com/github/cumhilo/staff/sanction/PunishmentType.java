package com.github.cumhilo.staff.sanction;

public enum PunishmentType {
    WARN, KICK, BAN, MUTE;

    public boolean isWarn() {
        return this == WARN;
    }

    public boolean isKick() {
        return this == KICK;
    }

    public boolean isBan() {
        return this == BAN;
    }

    public boolean isMute() {
        return this == MUTE;
    }

    public static PunishmentType fromString(String string) {
        return switch (string.toLowerCase()) {
            case "warn" -> WARN;
            case "kick" -> KICK;
            case "ban" -> BAN;
            case "mute" -> MUTE;
            default -> null;
        };
    }
}
