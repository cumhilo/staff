package com.gmail.vcamilx.staff.util.cache.implementation;

import com.gmail.vcamilx.staff.util.cache.IStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A generic implementation of {@link IStorage}.
 *
 * @param <K> The key type held by this {@link Storage}.
 * @param <V> The value type held by this {@link Storage}.
 */
public class Storage<K, V> implements IStorage<K, V> {

    private final ConcurrentMap<K, V> cache = new ConcurrentHashMap<>();

    @Override
    public Map<K, V> get() {
        return cache;
    }
}
