package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.module.Configurator;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.bukkit.CloudBukkitCapabilities;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.LegacyPaperCommandManager;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class CommandManagerConfigurator
        implements Configurator<LegacyPaperCommandManager<CommandSender>> {

    private final JavaPlugin plugin;
    private final @NotNull Logger logger;
    private LegacyPaperCommandManager<CommandSender> commandManager;

    public CommandManagerConfigurator(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getSLF4JLogger();
    }

    @Override
    public LegacyPaperCommandManager<CommandSender> configure() {
        commandManager = LegacyPaperCommandManager.createNative(
                plugin,
                ExecutionCoordinator.coordinatorFor(ExecutionCoordinator.nonSchedulingExecutor())
        );

        if (commandManager.hasCapability(CloudBukkitCapabilities.NATIVE_BRIGADIER)) {
            logger.info("Using native brigadier command manager");
            commandManager.registerBrigadier();
        }

        if (commandManager.hasCapability(CloudBukkitCapabilities.ASYNCHRONOUS_COMPLETION)) {
            logger.info("Using asynchronous command completion");
            commandManager.registerAsynchronousCompletions();
        }

        return commandManager;
    }

    public LegacyPaperCommandManager<CommandSender> get() {
        return commandManager;
    }
}
