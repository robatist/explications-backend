package com.robatist.backend.backend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super("Could not find user " + id);
    }

}
