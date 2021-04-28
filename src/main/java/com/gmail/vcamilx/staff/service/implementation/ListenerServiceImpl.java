package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.listener.staff.StaffBreakBlockEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffChatEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffDropItemEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractEntityEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractInventoryEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffJoinListener;
import com.gmail.vcamilx.staff.listener.staff.StaffPickUpItemEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffPlaceBlockEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeBreakBlockEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeDamageByEntityEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeDamageEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeDropItemEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeInteractInventoryEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeMoveListener;
import com.gmail.vcamilx.staff.listener.user.FreezePickUpItemEvent;
import com.gmail.vcamilx.staff.listener.user.FreezeProjectileEvent;
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
    private StaffInteractEntityEvent staffInteractEntityEvent;
    private StaffJoinListener staffJoinListener;
    private StaffPickUpItemEvent staffPickUpItemEvent;
    private StaffPlaceBlockEvent staffPlaceBlockEvent;

    private FreezeBreakBlockEvent freezeBreakBlockEvent;
    private FreezeDamageByEntityEvent freezeDamageByEntityEvent;
    private FreezeDamageEvent freezeDamageEvent;
    private FreezeDropItemEvent freezeDropItemEvent;
    private FreezeInteractInventoryEvent freezeInteractInventoryEvent;
    private FreezeMoveListener freezeMoveListener;
    private FreezePickUpItemEvent freezePickUpItemEvent;
    private FreezeProjectileEvent freezeProjectileEvent;

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
                staffInteractInventoryEvent,
                staffInteractEntityEvent,
                staffJoinListener,
                staffPickUpItemEvent,
                staffPlaceBlockEvent,
                freezeBreakBlockEvent,
                freezeDamageByEntityEvent,
                freezeDamageEvent,
                freezeDropItemEvent,
                freezeInteractInventoryEvent,
                freezeMoveListener,
                freezePickUpItemEvent,
                freezeDamageEvent
        );
    }
}
