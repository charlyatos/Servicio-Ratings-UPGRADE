package com.api.ratingscourse.exceptions.exceptionclasses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordAlreadyExists extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecordAlreadyExists(String message) {
        super(message);
    }
}
