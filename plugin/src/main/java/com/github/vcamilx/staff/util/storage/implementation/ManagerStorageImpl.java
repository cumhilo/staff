package com.github.vcamilx.staff.util.storage.implementation;

import com.github.vcamilx.staff.core.storage.IStorage;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ManagerStorageImpl implements IStorage<UUID, ItemStack[]> {

    private final Map<UUID, ItemStack[]> staffManager = new ConcurrentHashMap<>();

    public Map<UUID, ItemStack[]> get() {
        return staffManager;
    }
}