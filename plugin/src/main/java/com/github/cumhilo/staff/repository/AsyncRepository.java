package com.github.cumhilo.staff.repository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncRepository<T> {

    CompletableFuture<Void> save(String filePath, T data);

    CompletableFuture<T> findById(String filePath, Class<T> classOfT);

    CompletableFuture<T> findById(String filePath, Type typeOfT);

    CompletableFuture<Void> deleteById(String filePath);

    CompletableFuture<List<T>> findAll();
}
