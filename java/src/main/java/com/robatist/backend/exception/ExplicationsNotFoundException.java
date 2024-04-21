package com.robatist.backend.exception;

public class ExplicationsNotFoundException extends RuntimeException {
    public ExplicationsNotFoundException() {
        super("Could not find explications");
    }
}
