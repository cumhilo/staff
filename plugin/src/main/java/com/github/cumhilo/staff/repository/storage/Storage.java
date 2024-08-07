package com.github.cumhilo.staff.repository.storage;

import com.github.cumhilo.staff.repository.AsyncRepository;
import com.github.cumhilo.staff.repository.Repository;
import com.github.cumhilo.staff.repository.SyncRepository;
import com.github.cumhilo.staff.repository.impl.AsyncRepositoryImpl;
import com.github.cumhilo.staff.repository.impl.SyncRepositoryImpl;
import com.github.cumhilo.staff.repository.local.gson.GsonAsyncStorage;
import com.github.cumhilo.staff.repository.local.gson.GsonSyncStorage;
import com.google.gson.Gson;

public class Storage<T>
        implements Repository<T> {

    private final SyncRepository<T> syncStorage;
    private final AsyncRepository<T> asyncStorage;

    public Storage(SyncRepository<T> syncStorage, AsyncRepository<T> asyncStorage) {
        this.syncStorage = syncStorage;
        this.asyncStorage = asyncStorage;
    }

    public SyncRepository<T> getSyncStorage() {
        return syncStorage;
    }

    public AsyncRepository<T> getAsyncStorage() {
        return asyncStorage;
    }

    public static <T> Repository<T> createGson(Gson gson, String baseDirectory, Class<T> clazz) {
        SyncStorage<T> syncStorage = new GsonSyncStorage<>(gson, baseDirectory, clazz);
        AsyncStorage<T> asyncStorage = new GsonAsyncStorage<>(gson, baseDirectory, clazz);

        return new Storage<>(new SyncRepositoryImpl<>(syncStorage), new AsyncRepositoryImpl<>(asyncStorage));
    }

    @Override
    public SyncRepository<T> sync() {
        return syncStorage;
    }

    @Override
    public AsyncRepository<T> async() {
        return asyncStorage;
    }
}
