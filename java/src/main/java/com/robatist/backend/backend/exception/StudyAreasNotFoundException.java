package com.robatist.backend.backend.exception;

public class StudyAreasNotFoundException extends RuntimeException {
    public StudyAreasNotFoundException() {
        super("Could not find Study Areas");
    }

}
