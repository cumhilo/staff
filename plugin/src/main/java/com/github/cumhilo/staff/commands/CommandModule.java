package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.module.Module;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.annotations.AnnotationParser;
import org.incendo.cloud.paper.LegacyPaperCommandManager;
import org.incendo.cloud.processors.cooldown.CooldownManager;

public class CommandModule implements Module {

    private final JavaPlugin plugin;

    public CommandModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void configure() {
        CommandManagerConfigurator managerConfigurator = new CommandManagerConfigurator(plugin);
        LegacyPaperCommandManager<CommandSender> commandManager = managerConfigurator.configure();

        CommandCooldownConfigurator cooldownConfigurator = new CommandCooldownConfigurator();
        CooldownManager<CommandSender> cooldownManager = cooldownConfigurator.configure();
        commandManager.registerCommandPostProcessor(cooldownManager.createPostprocessor());

        AnnotationParserConfigurator parserConfigurator = new AnnotationParserConfigurator(commandManager);
        AnnotationParser<CommandSender> annotationParser = parserConfigurator.configure();

        CommandRegistry registry = new CommandRegistry(plugin, annotationParser);
        registry.setup();
    }
}
