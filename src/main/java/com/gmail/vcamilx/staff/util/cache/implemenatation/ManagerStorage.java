package com.gmail.vcamilx.staff.util.cache.implemenatation;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ManagerStorage implements IStorage<UUID, ItemStack[]> {

    private final Map<UUID, ItemStack[]> staffManager = new HashMap<>();

    public Map<UUID, ItemStack[]> get() {
        return staffManager;
    }

    public void add(UUID key, ItemStack[] value) {
        this.get().put(key, value);
    }

    public void remove(UUID key) {
        this.get().remove(key);
    }

    public Optional<ItemStack[]> find(UUID key) {
        return Optional.ofNullable(this.get().get(key));
    }

    public ItemStack[] getValue(UUID key) {
        return get().get(key);
    }

    public boolean exists(UUID key) {
        return this.get().containsKey(key);
    }
}
