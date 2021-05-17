package com.gmail.vcamilx.staff.service.implementation;

import com.gmail.vcamilx.staff.Staff;
import com.gmail.vcamilx.staff.listener.staff.StaffBlockBreakListener;
import com.gmail.vcamilx.staff.listener.staff.StaffChatListener;
import com.gmail.vcamilx.staff.listener.staff.StaffDropItemListener;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractAtEntityListener;
import com.gmail.vcamilx.staff.listener.staff.StaffInteractListener;
import com.gmail.vcamilx.staff.listener.staff.StaffInventoryClickListener;
import com.gmail.vcamilx.staff.listener.staff.StaffJoinListener;
import com.gmail.vcamilx.staff.listener.staff.StaffPickupItemListener;
import com.gmail.vcamilx.staff.listener.staff.StaffBlockPlaceListener;
import com.gmail.vcamilx.staff.listener.user.FreezeBreakBlockListener;
import com.gmail.vcamilx.staff.listener.user.FreezeDamageByEntityListener;
import com.gmail.vcamilx.staff.listener.user.FreezeDamageListener;
import com.gmail.vcamilx.staff.listener.user.FreezeDropItemListener;
import com.gmail.vcamilx.staff.listener.user.FreezeInventoryClickListener;
import com.gmail.vcamilx.staff.listener.user.FreezeMoveListener;
import com.gmail.vcamilx.staff.listener.user.FreezePickupItemListener;
import com.gmail.vcamilx.staff.listener.user.FreezeProjectileLaunchEvent;
import com.gmail.vcamilx.staff.service.IService;
import me.yushust.inject.InjectAll;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@InjectAll
@SuppressWarnings("unused")
public class ListenerServiceImpl implements IService {

    private Staff staff;

    private StaffBlockBreakListener staffBlockBreakListener;
    private StaffChatListener staffChatListener;
    private StaffDropItemListener staffDropItemListener;
    private StaffInventoryClickListener staffInventoryClickListener;
    private StaffInteractListener staffInteractEvent;
    private StaffInteractAtEntityListener staffInteractAtEntityListener;
    private StaffJoinListener staffJoinListener;
    private StaffPickupItemListener staffPickUpItemListener;
    private StaffBlockPlaceListener staffBlockPlaceListener;

    private FreezeBreakBlockListener freezeBreakBlockListener;
    private FreezeDamageByEntityListener freezeDamageByEntityListener;
    private FreezeDamageListener freezeDamageListener;
    private FreezeDropItemListener freezeDropItemListener;
    private FreezeInventoryClickListener freezeInventoryClickListener;
    private FreezeMoveListener freezeMoveListener;
    private FreezePickupItemListener freezePickUpItemListener;
    private FreezeProjectileLaunchEvent freezeProjectileLaunchEvent;

    private void registerListener(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, staff);
        }
    }

    @Override
    public void start() {
        registerListener(
            staffBlockBreakListener,
            staffChatListener,
            staffDropItemListener,
            staffInventoryClickListener,
                staffInteractEvent,
            staffInteractAtEntityListener,
                staffJoinListener,
            staffPickUpItemListener,
            staffBlockPlaceListener,
            freezeBreakBlockListener,
            freezeDamageByEntityListener,
            freezeDamageListener,
            freezeDropItemListener,
            freezeInventoryClickListener,
                freezeMoveListener,
            freezePickUpItemListener,
            freezeDamageListener
        );
    }
}
