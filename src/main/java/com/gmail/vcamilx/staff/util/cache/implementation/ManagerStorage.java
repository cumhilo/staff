package com.gmail.vcamilx.staff.util.cache.implementation;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ManagerStorage implements IStorage<UUID, ItemStack[]> {

    private final Map<UUID, ItemStack[]> staffManager = new ConcurrentHashMap<>();

    public Map<UUID, ItemStack[]> get() {
        return staffManager;
    }
}
