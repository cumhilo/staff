package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.listener.*;
import com.gmail.vcamilx.staff.service.IService;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@InjectAll
public class ListenerServiceImpl implements IService {
    private Staff staff;
    private StaffBlockListener staffBlockListener;
    private StaffChatListener staffChatListener;
    private StaffInteractListener staffInteractListener;
    private StaffInventoryListener staffInventoryListener;
    private StaffJoinListener staffJoinListener;

    private void registerListener(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, staff);
        }
    }

    @Override
    public void start() {
        registerListener(
                staffBlockListener,
                staffChatListener,
                staffInteractListener,
                staffInventoryListener,
                staffJoinListener
        );
    }
}
