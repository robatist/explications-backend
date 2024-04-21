package com.robatist.backend.backend.exception;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
        super("Could not find users");
    }
}
