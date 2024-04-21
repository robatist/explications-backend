package com.robatist.backend.exception;

public class SessionsNotFoundException extends RuntimeException {
    public SessionsNotFoundException() {
        super("Could not find sessions");
    }
}
