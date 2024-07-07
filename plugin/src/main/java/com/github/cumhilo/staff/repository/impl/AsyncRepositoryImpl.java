package com.github.cumhilo.staff.repository.impl;

import com.github.cumhilo.staff.repository.AsyncRepository;
import com.github.cumhilo.staff.repository.storage.AsyncStorage;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AsyncRepositoryImpl<T> implements AsyncRepository<T> {

    private final AsyncStorage<T> asyncStorage;

    public AsyncRepositoryImpl(AsyncStorage<T> asyncStorage) {
        this.asyncStorage = asyncStorage;
    }

    @Override
    public CompletableFuture<Void> save(String filePath, T data) {
        return asyncStorage.write(filePath, data);
    }

    @Override
    public CompletableFuture<T> findById(String filePath, Class<T> classOfT) {
        return asyncStorage.read(filePath, classOfT);
    }

    @Override
    public CompletableFuture<T> findById(String filePath, Type typeOfT) {
        return asyncStorage.read(filePath, typeOfT);
    }

    @Override
    public CompletableFuture<Void> deleteById(String filePath) {
        return asyncStorage.delete(filePath);
    }

    @Override
    public CompletableFuture<List<T>> findAll() {
        return asyncStorage.files();
    }
}