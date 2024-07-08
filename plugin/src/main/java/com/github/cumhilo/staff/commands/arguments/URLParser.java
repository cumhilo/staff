package com.github.cumhilo.staff.commands.arguments;

import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.context.CommandInput;
import org.incendo.cloud.parser.ArgumentParseResult;
import org.incendo.cloud.parser.ArgumentParser;

import java.net.URL;

public class URLParser
        implements ArgumentParser<CommandSender, URL> {
    @Override
    public @NonNull ArgumentParseResult<@NonNull URL> parse(@NonNull CommandContext<@NonNull CommandSender> ctx, @NonNull CommandInput cmdInput) {
        final var input = cmdInput.readString();

        try {
            return ArgumentParseResult.success(new URL(input));
        } catch (Exception e) {
            return ArgumentParseResult.failure(new RuntimeException("Invalid URL."));
        }
    }
}
