package com.gmail.vcamilx.staff.util.cache.implemenatation;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManagerStorage implements IStorage<UUID, ItemStack[]> {

    private final Map<UUID, ItemStack[]> staffManager = new HashMap<>();

    @Override
    public Map<UUID, ItemStack[]> get() {
        return staffManager;
    }
}
