package com.robatist.backend.service.advice;

import com.robatist.backend.exception.ExplicationNotFoundException;
import com.robatist.backend.exception.ExplicationsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExplicationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ExplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String explicationNotFoundHandler(ExplicationNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ExplicationsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String explicationsNotFoundHandler(ExplicationsNotFoundException exception) {
        return exception.getMessage();
    }

}
