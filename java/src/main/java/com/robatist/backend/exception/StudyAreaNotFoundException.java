package com.robatist.backend.exception;

public class StudyAreaNotFoundException extends RuntimeException {
    public StudyAreaNotFoundException(int id) {
        super("Could not find Study Area " + id);
    }
}
