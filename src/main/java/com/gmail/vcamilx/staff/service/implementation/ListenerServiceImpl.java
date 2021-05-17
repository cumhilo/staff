package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.listener.staff.StaffBlockBreakListener;
import com.gmail.vcamilx.staff.listener.staff.StaffChatEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffDropItemEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractAtEntityEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractListener;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractInventoryEvent;
import com.gmail.vcamilx.staff.listener.staff.StaffJoinListener;
import com.gmail.vcamilx.staff.listener.staff.StaffPickUpItemListener;
import com.gmail.vcamilx.staff.listener.staff.StaffBlockPlaceListener;
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
@SuppressWarnings("unused")
public class ListenerServiceImpl implements IService {

    private Staff staff;

    private StaffBlockBreakListener staffBlockBreakListener;
    private StaffChatEvent staffChatEvent;
    private StaffDropItemEvent staffDropItemEvent;
    private StaffInteractInventoryEvent staffInteractInventoryEvent;
    private StaffInteractListener staffInteractEvent;
    private StaffInteractAtEntityEvent staffInteractAtEntityEvent;
    private StaffJoinListener staffJoinListener;
    private StaffPickUpItemListener staffPickUpItemListener;
    private StaffBlockPlaceListener staffBlockPlaceListener;

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
            staffBlockBreakListener,
                staffChatEvent,
                staffDropItemEvent,
                staffInteractInventoryEvent,
                staffInteractEvent,
            staffInteractAtEntityEvent,
                staffJoinListener,
            staffPickUpItemListener,
            staffBlockPlaceListener,
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
