package com.robatist.backend.exception;

public class StudyAreasNotFoundException extends RuntimeException {
    public StudyAreasNotFoundException() {
        super("Could not find Study Areas");
    }

}
