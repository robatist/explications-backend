package com.robatist.backend.exception;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
        super("Could not find users");
    }
}
