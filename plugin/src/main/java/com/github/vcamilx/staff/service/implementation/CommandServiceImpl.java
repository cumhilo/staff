package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.command.FreezeCommand;
import com.github.vcamilx.staff.core.service.IService;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.yushust.inject.InjectAll;

@InjectAll
public class CommandServiceImpl implements IService {

    private FreezeCommand freezeCommand;

    public void start() {
        registerCommands(
                freezeCommand
        );
    }

    @Override
    public void stop() {

    }

    private void registerCommands(CommandClass... commandClasses) {
        PartInjector injector = PartInjector.create();
        injector.install(new DefaultsModule());
        injector.install(new BukkitModule());

        CommandManager bukkitCommandManager = new BukkitCommandManager("Staff");
        AnnotatedCommandTreeBuilder builder = AnnotatedCommandTreeBuilder.create(injector);

        for (CommandClass commandClass : commandClasses) {
            bukkitCommandManager.registerCommands(builder.fromClass(commandClass));
        }
    }
}
