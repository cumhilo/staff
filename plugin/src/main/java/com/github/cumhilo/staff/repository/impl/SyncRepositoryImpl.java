package com.github.cumhilo.staff.repository.impl;

import com.github.cumhilo.staff.handler.ExceptionHandler;
import com.github.cumhilo.staff.repository.SyncRepository;
import com.github.cumhilo.staff.repository.storage.SyncStorage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class SyncRepositoryImpl<T> implements SyncRepository<T> {

    private final ExceptionHandler exceptionHandler = ExceptionHandler.createRuntime(SyncRepositoryImpl.class);

    private final SyncStorage<T> syncStorage;

    public SyncRepositoryImpl(SyncStorage<T> syncStorage) {
        this.syncStorage = syncStorage;
    }

    @Override
    public void save(String filePath, T data) {
        try {
            syncStorage.write(filePath, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(String filePath, Class<T> classOfT) {
        try {
            return syncStorage.read(filePath, classOfT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(String filePath, Type typeOfT) {
        try {
            return syncStorage.read(filePath, typeOfT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String filePath) {
        try {
            syncStorage.delete(filePath);
        } catch (IOException e) {
            exceptionHandler.handle(e);
        }
    }

    @Override
    public List<T> findAll() {
        return syncStorage.files();
    }
}