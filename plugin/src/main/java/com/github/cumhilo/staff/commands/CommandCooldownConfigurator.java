package com.github.cumhilo.staff.commands;

import com.github.cumhilo.staff.module.Configurator;
import org.bukkit.command.CommandSender;
import org.incendo.cloud.processors.cooldown.CooldownConfiguration;
import org.incendo.cloud.processors.cooldown.CooldownManager;
import org.incendo.cloud.processors.cooldown.CooldownRepository;
import org.incendo.cloud.processors.cooldown.listener.ScheduledCleanupCreationListener;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.github.cumhilo.staff.StaffPermissions.BYPASS_COMMAND_COOLDOWN;

public class CommandCooldownConfigurator
        implements Configurator<CooldownManager<CommandSender>> {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final CooldownRepository<CommandSender> cooldownRepository;

    public CommandCooldownConfigurator() {
        this.cooldownRepository = CooldownRepository.mapping(
                CommandSender::getName,
                CooldownRepository.forMap(new HashMap<>()));
    }

    @Override
    public CooldownManager<CommandSender> configure() {
        final var cooldownConfig = CooldownConfiguration.<CommandSender>builder()
                .repository(cooldownRepository)
                .bypassCooldown(sender -> sender.hasPermission(BYPASS_COMMAND_COOLDOWN))
                .addCreationListener(new ScheduledCleanupCreationListener<>(scheduler, cooldownRepository))
                .addActiveCooldownListener((sender, command, cooldown, remainingTime) -> {
                    sender.sendMessage(String.format("You must wait %s seconds before using this command again", remainingTime));
                })
                .build();

        return CooldownManager.cooldownManager(cooldownConfig);
    }
}