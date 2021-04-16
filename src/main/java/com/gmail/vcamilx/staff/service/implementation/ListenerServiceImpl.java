package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.listener.staff.*;
import com.gmail.vcamilx.staff.listener.user.FreezeDropItemEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeInteractInventoryEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeMoveListener;
import com.gmail.vcamilx.staff.listener.user.FreezePickUpItemEvent;
import com.gmail.vcamilx.staff.service.IService;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@InjectAll
public class ListenerServiceImpl implements IService {

    private Staff staff;

    private StaffBreakBlockEvent staffBreakBlockEvent;
    private StaffChatEvent staffChatEvent;
    private StaffDropItemEvent staffDropItemEvent;
    private StaffInteractInventoryEvent staffInteractInventoryEvent;
    private StaffInteractListener staffInteractListener;
    private StaffJoinListener staffJoinListener;
    private StaffPickUpItemEvent staffPickUpItemEvent;
    private StaffPlaceBlockEvent staffPlaceBlockEvent;

    private FreezeDropItemEvent freezeDropItemEvent;
    private FreezeInteractInventoryEvent freezeInteractInventoryEvent;
    private FreezeMoveListener freezeMoveListener;
    private FreezePickUpItemEvent freezePickUpItemEvent;

    private void registerListener(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, staff);
        }
    }

    @Override
    public void start() {
        registerListener(
                staffBreakBlockEvent,
                staffChatEvent,
                staffDropItemEvent,
                staffInteractListener,
                staffJoinListener,
                staffPickUpItemEvent,
                staffPlaceBlockEvent,
                freezeDropItemEvent,
                freezeInteractInventoryEvent,
                freezeMoveListener,
                freezePickUpItemEvent
        );
    }
}
