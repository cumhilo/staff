package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.module.Module;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandModule implements Module {

    private final JavaPlugin plugin;

    public CommandModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void configure() {
        final var commandManager = new CommandManagerConfigurator(plugin).configure();
        final var cooldownManager = new CommandCooldownConfigurator().configure();

        commandManager.registerCommandPostProcessor(cooldownManager.createPostprocessor());

        final var annotationParser = new AnnotationParserConfigurator(commandManager).configure();
        final var registry = new CommandRegistry(plugin, annotationParser);

        registry.setup();
    }
}
