package com.robatist.backend.exception;

public class ExplicationNotFoundException extends RuntimeException {
    public ExplicationNotFoundException(int id) {
        super("Could not find explication " + id);
    }
}
