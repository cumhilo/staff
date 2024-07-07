package com.github.cumhilo.staff.repository;

public interface Repository<T> {

    /**
     * Get the repository for synchronous operations
     *
     * @return the repository for synchronous operations
     */
    SyncRepository<T> sync();

    /**
     * Get the repository for asynchronous operations
     *
     * @return the repository for asynchronous operations
     */
    AsyncRepository<T> async();
}