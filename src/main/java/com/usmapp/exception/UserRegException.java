package com.usmapp.exception;


public class UserRegException extends RuntimeException {
    public UserRegException(String message) {
        super(message);
    }

    public UserRegException(String message, Throwable cause) {
        super(message, cause);
    }
}
