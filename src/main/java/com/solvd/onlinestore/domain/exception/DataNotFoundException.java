package com.solvd.onlinestore.domain.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
