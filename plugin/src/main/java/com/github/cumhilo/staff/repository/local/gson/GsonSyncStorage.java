package com.github.cumhilo.staff.repository.local.gson;

import com.github.cumhilo.staff.handler.ExceptionHandler;
import com.github.cumhilo.staff.repository.storage.SyncStorage;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GsonSyncStorage<T>
        implements SyncStorage<T> {

    private final Gson gson;
    private final Path storagePath;

    public GsonSyncStorage(Gson gson, String baseDirectory, Class<T> clazz) {
        this.gson = gson;
        this.storagePath = Paths.get(baseDirectory, clazz.getSimpleName().toLowerCase());
        createDirectoryIfNotExists(storagePath);
    }

    private void createDirectoryIfNotExists(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating storage directory", e);
        }
    }

    private Path getFilePath(String fileName) {
        return storagePath.resolve(fileName);
    }

    @Override
    public void write(String fileName, T data) throws IOException {
        Path filePath = getFilePath(fileName);
        Files.createDirectories(filePath.getParent());

        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            gson.toJson(data, writer);
        }
    }

    @Override
    public T read(String fileName, Class<T> classOfT) throws IOException {
        Path filePath = getFilePath(fileName);

        try (FileReader reader = new FileReader(filePath.toFile())) {
            return gson.fromJson(reader, classOfT);
        }
    }

    @Override
    public T read(String fileName, Type typeOfT) throws IOException {
        Path filePath = getFilePath(fileName);

        try (FileReader reader = new FileReader(filePath.toFile())) {
            return gson.fromJson(reader, typeOfT);
        }
    }

    @Override
    public void delete(String fileName) throws IOException {
        Path filePath = getFilePath(fileName);
        Files.delete(filePath);
    }

    @Override
    public List<T> files() {
        Path start = getStoragePath();
        try (Stream<Path> paths = Files.walk(start)) {
            return paths.filter(Files::isRegularFile)
                    .map(path -> {
                        try {
                            return read(path.getFileName().toString(), (Class<T>) Class.forName(start.getFileName().toString()));
                        } catch (Exception e) {
                            ExceptionHandler.createRuntime(GsonSyncStorage.class).handle(e);
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path getStoragePath() {
        return storagePath;
    }
}