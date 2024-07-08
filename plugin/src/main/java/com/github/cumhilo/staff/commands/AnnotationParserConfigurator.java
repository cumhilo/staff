package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.commands.arguments.GamemodeParser;
import com.github.cumhilo.staff.commands.arguments.URLParser;
import com.github.cumhilo.staff.module.Configurator;
import io.leangen.geantyref.TypeToken;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.incendo.cloud.annotations.AnnotationParser;
import org.incendo.cloud.paper.LegacyPaperCommandManager;

import java.net.URL;

public class AnnotationParserConfigurator
        implements Configurator<AnnotationParser<CommandSender>> {

    private final LegacyPaperCommandManager<CommandSender> commandManager;

    public AnnotationParserConfigurator(LegacyPaperCommandManager<CommandSender> commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public AnnotationParser<CommandSender> configure() {
        final var annotationParser = new AnnotationParser<>(commandManager, CommandSender.class);
        final var parserRegistry = commandManager.parserRegistry();

        parserRegistry.registerParserSupplier(TypeToken.get(GameMode.class), options -> new GamemodeParser());
        parserRegistry.registerParserSupplier(TypeToken.get(URL.class), options -> new URLParser());

        return annotationParser;
    }
}