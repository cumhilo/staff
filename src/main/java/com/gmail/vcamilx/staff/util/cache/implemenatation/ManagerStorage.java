package com.gmail.vcamilx.staff.util.cache.implemenatation;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ManagerStorage implements IStorage<UUID, ItemStack[]> {

    private final Map<UUID, ItemStack[]> staffManager = new HashMap<>();

    @Override
    public Map<UUID, ItemStack[]> get() {
        return staffManager;
    }


    @Override
    public void add(UUID key, ItemStack[] value) {
        this.get().put(key, value);
    }

    @Override
    public void remove(UUID key) {
        this.get().remove(key);
    }

    @Override
    public Optional<ItemStack[]> find(UUID key) {
        return Optional.ofNullable(this.get().get(key));
    }

    @Override
    public ItemStack[] getValue(UUID key) {
        return get().get(key);
    }

    @Override
    public boolean exists(UUID key) {
        return this.get().containsKey(key);
    }
}
