package com.robatist.backend.backend.service.advice;

import com.robatist.backend.backend.exception.SessionNotFoundException;
import com.robatist.backend.backend.exception.SessionsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SessionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String sessionNotFoundHandler(SessionNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SessionsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String sessionsNotFoundHandler(SessionsNotFoundException exception) {
        return exception.getMessage();
    }

}
