package com.github.cumhilo.staff.repository.local.gson;

import com.github.cumhilo.staff.handler.ExceptionHandler;
import com.github.cumhilo.staff.repository.storage.AsyncStorage;
import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GsonAsyncStorage<T> implements AsyncStorage<T> {

    private final ExceptionHandler exceptionHandler = ExceptionHandler.createRuntime(GsonAsyncStorage.class);

    private final GsonSyncStorage<T> syncStorage;
    private final ExecutorService executorService;

    public GsonAsyncStorage(Gson gson, String baseDirectory, Class<T> clazz) {
        this.syncStorage = new GsonSyncStorage<>(gson, baseDirectory, clazz);
        this.executorService = Executors.newCachedThreadPool();
    }

    @Override
    public CompletableFuture<Void> write(String fileName, T data) {
        return runAsync(() -> {
            try {
                syncStorage.write(fileName, data);
            } catch (IOException e) {
                exceptionHandler.handle(e);
            }
        });
    }

    @Override
    public CompletableFuture<T> read(String fileName, Class<T> classOfT) {
        return supplyAsync(() -> {
            try {
                return syncStorage.read(fileName, classOfT);
            } catch (IOException e) {
                exceptionHandler.handle(e);
                return null;
            }
        });
    }

    @Override
    public CompletableFuture<T> read(String fileName, Type typeOfT) {
        return supplyAsync(() -> {
            try {
                return syncStorage.read(fileName, typeOfT);
            } catch (IOException e) {
                exceptionHandler.handle(e);
                return null;
            }
        });
    }

    @Override
    public CompletableFuture<Void> delete(String fileName) {
        return runAsync(() -> {
            try {
                syncStorage.delete(fileName);
            } catch (IOException e) {
                exceptionHandler.handle(e);
            }
        });
    }

    @Override
    public CompletableFuture<List<T>> files() {
        return supplyAsync(() -> {
            try (Stream<Path> paths = Files.walk(syncStorage.getStoragePath())) {
                return paths.filter(Files::isRegularFile)
                        .map(path -> {
                            try {
                                return syncStorage.read(path.getFileName().toString(), (Class<T>) Class.forName(syncStorage.getStoragePath().getFileName().toString()));
                            } catch (Exception e) {
                                exceptionHandler.handle(e);
                                return null;
                            }
                        })
                        .collect(Collectors.toList());
            } catch (IOException e) {
                exceptionHandler.handle(e);
                return List.of();
            }
        });
    }

    private CompletableFuture<Void> runAsync(Runnable task) {
        return CompletableFuture.runAsync(() -> {
            try {
                task.run();
            } catch (Exception e) {
                exceptionHandler.handle(e);
            }
        }, executorService);
    }

    private <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return supplier.get();
            } catch (Exception e) {
                exceptionHandler.handle(e);
                return null;
            }
        }, executorService);
    }

    @FunctionalInterface
    private interface Supplier<U> {
        U get() throws Exception;
    }
}
