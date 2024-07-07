package com.github.cumhilo.staff.repository.storage;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncStorage<T> {

    CompletableFuture<Void> write(String fileName, T data);

    CompletableFuture<T> read(String fileName, Class<T> classOfT);

    CompletableFuture<T> read(String fileName, Type typeOfT);

    CompletableFuture<Void> delete(String fileName);

    CompletableFuture<List<T>> files();
}
