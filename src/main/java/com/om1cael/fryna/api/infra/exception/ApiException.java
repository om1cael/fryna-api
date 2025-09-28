package com.om1cael.fryna.api.infra.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final int code;
    private final HttpStatus httpStatus;

    public ApiException(String message, int code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
