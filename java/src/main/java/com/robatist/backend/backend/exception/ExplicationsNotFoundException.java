package com.robatist.backend.backend.exception;

public class ExplicationsNotFoundException extends RuntimeException {
    public ExplicationsNotFoundException() {
        super("Could not find explications");
    }
}
