package com.github.cumhilo.staff.commands.arguments;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.context.CommandInput;
import org.incendo.cloud.parser.ArgumentParseResult;
import org.incendo.cloud.parser.ArgumentParser;

import java.util.HashMap;
import java.util.Map;

public class GamemodeParser
        implements ArgumentParser<CommandSender, GameMode> {

    public static final Map<String, GameMode> GAMEMODE_ALIASES = new HashMap<>();

    static {
        for (GameMode gameMode : GameMode.values()) {
            aliases(Integer.toString(gameMode.getValue()), gameMode);

            String gameModeName = gameMode.name().toLowerCase();
            aliases(gameModeName, gameMode);

            if (gameMode == GameMode.SPECTATOR) {
                aliases("spec", gameMode);
                aliases("sp", gameMode);
                continue;
            }

            aliases(Character.toString(gameModeName.charAt(0)), gameMode);
        }
    }

    public static void aliases(String alias, GameMode gameMode) {
        GAMEMODE_ALIASES.put(alias.toLowerCase(), gameMode);
    }


    @Override
    public @NonNull ArgumentParseResult<@NonNull GameMode> parse(@NonNull CommandContext<@NonNull CommandSender> ctx, @NonNull CommandInput cmdInput) {
        final var input = cmdInput.readString();
        final var gameMode = GAMEMODE_ALIASES.get(input.toLowerCase());

        if (gameMode == null) {
            return ArgumentParseResult.failure(new RuntimeException("Invalid game mode."));
        }

        return ArgumentParseResult.success(gameMode);
    }
}
