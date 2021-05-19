package com.github.vcamilx.staff.core.storage;

import java.util.Map;
import java.util.Optional;

public interface IStorage<K, V> {
    Map<K, V> get();

    default void add(K key, V value) {
        get().put(key, value);
    }

    default void remove(K key) {
        get().remove(key);
    }

    default Optional<V> find(K key) {
        return Optional.ofNullable(get().get(key));
    }

    default V getValue(K key) {
        return get().get(key);
    }

    default boolean exists(K key) {
        return get().containsKey(key);
    }
}