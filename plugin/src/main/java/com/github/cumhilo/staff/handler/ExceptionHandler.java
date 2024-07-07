package com.github.cumhilo.staff.handler;

@FunctionalInterface
public interface ExceptionHandler {

    /**
     * Handle the exception
     *
     * @param e the exception
     */
    void handle(Exception e);

    static ExceptionHandler createRuntime(Class<?> clazz) {
        return e -> {
            throw new RuntimeException(String.format("An error occurred in %s", clazz.getSimpleName()), e);
        };
    }
}