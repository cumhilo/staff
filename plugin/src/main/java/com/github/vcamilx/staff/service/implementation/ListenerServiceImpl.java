package com.github.vcamilx.staff.service.implementation;

import com.github.vcamilx.staff.Staff;
import com.github.vcamilx.staff.core.service.IService;
import me.yushust.inject.InjectAll;

@InjectAll
@SuppressWarnings("unused")
public class ListenerServiceImpl implements IService {

    private Staff staff;

    /*private StaffBlockBreakListener staffBlockBreakListener;
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
            Bukkit.getLogger().info(listener + " has been loaded");
        }
    }*/

    @Override
    public void start() {
        /*registerListener(
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
        );*/
    }

    @Override
    public void stop() {

    }
}