package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.command.FreezeCommand;
import com.github.vcamilx.staff.command.InventorySeeCommand;
import com.github.vcamilx.staff.command.chat.SocialSpyCommand;
import com.github.vcamilx.staff.command.sanctions.SanctionCommand;
import com.github.vcamilx.staff.command.staff.StaffChatCommand;
import com.github.vcamilx.staff.command.staff.StaffCheckCommand;
import com.github.vcamilx.staff.command.staff.StaffCommand;
import com.github.vcamilx.staff.core.service.IService;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;

@InjectAll
public class CommandServiceImpl implements IService {

    private FreezeCommand freezeCommand;
    private InventorySeeCommand inventorySeeCommand;
    private SocialSpyCommand socialSpyCommand;
    private SanctionCommand sanctionCommand;
    private StaffCheckCommand staffCheckCommand;
    private StaffChatCommand staffChatCommand;
    private StaffCommand staffCommand;

    public void start() {
        registerCommands(
                freezeCommand,
                inventorySeeCommand,
                sanctionCommand,
                socialSpyCommand,
                staffChatCommand,
                staffCheckCommand,
                staffCommand
        );
        Bukkit
                .getLogger()
                .info("All commands has been loaded");
    }

    @Override
    public void stop() {
        Bukkit
                .getLogger()
                .info("All commands has been disabled");
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
