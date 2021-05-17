package com.gmail.vcamilx.staff.module;

import com.gmail.vcamilx.staff.util.cache.IStorage;
import com.gmail.vcamilx.staff.util.cache.implemenatation.ManagerStorage;
import com.gmail.vcamilx.staff.util.cache.implemenatation.Storage;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.key.TypeReference;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class StorageModule extends AbstractModule {

    @Override
    protected void configure() {
        bindStorage(UUID.class, ItemStack[].class);
    }

    private void bindStorage(Class<?> keyType, Class<?> valueType) {
        bind(TypeReference.of(IStorage.class, keyType, valueType)).to(TypeReference.of(Storage.class, keyType, valueType)).singleton();
    }
}
