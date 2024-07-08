package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.commands.commons.TeleportCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.annotations.AnnotationParser;

public class CommandRegistry {

    private final JavaPlugin plugin; // ignored by now, but ww're going to use it later
    private final AnnotationParser<CommandSender> annotationParser;

    public CommandRegistry(JavaPlugin plugin, AnnotationParser<CommandSender> annotationParser) {
        this.plugin = plugin;
        this.annotationParser = annotationParser;
    }

    public void setup() {
        annotationParser.parse(
                new TeleportCommand()
        );
    }
}
