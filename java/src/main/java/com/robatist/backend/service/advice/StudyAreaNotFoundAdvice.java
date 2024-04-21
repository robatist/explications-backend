package com.robatist.backend.service.advice;

import com.robatist.backend.exception.StudyAreaNotFoundException;
import com.robatist.backend.exception.StudyAreasNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudyAreaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StudyAreaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String studyAreaNotFoundHandler(StudyAreaNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(StudyAreasNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String studyAreasNotFoundHandler(StudyAreasNotFoundException exception) {
        return exception.getMessage();
    }

}
