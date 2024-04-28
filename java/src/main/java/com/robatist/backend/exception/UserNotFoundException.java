package com.robatist.backend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super("Could not find user " + id);
    }

    public UserNotFoundException(String email) {
        super("Could not find user " + email);
    }

}
