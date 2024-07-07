package com.github.cumhilo.staff.repository;

import java.lang.reflect.Type;
import java.util.List;

public interface SyncRepository<T> {

    void save(String filePath, T data);

    T findById(String filePath, Class<T> classOfT);

    T findById(String filePath, Type typeOfT);

    void deleteById(String filePath);

    List<T> findAll();
}
