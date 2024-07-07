package com.github.cumhilo.staff.repository.storage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface SyncStorage<T> {

    void write(String fileName, T data) throws IOException;

    T read(String fileName, Class<T> classOfT) throws IOException;

    T read(String fileName, Type typeOfT) throws IOException;

    void delete(String fileName) throws IOException;

    List<T> files();
}

