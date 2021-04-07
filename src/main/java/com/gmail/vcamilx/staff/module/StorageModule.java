package com.gmail.vcamilx.staff.module;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import com.gmail.vcamilx.staff.util.cache.implemenatation.ManagerStorage;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.key.TypeReference;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class StorageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeReference<IStorage<UUID, ItemStack[]>>(){}).named("staff-manager").to(ManagerStorage.class).singleton();
    }
}
