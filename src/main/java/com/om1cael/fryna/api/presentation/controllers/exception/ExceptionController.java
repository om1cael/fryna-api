package com.om1cael.fryna.api.presentation.controllers.exception;

import com.om1cael.fryna.api.data.dtos.ExceptionDTO;
import com.om1cael.fryna.api.infra.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ApiException.class)
    private ResponseEntity<ExceptionDTO> apiException(ApiException e, HttpServletRequest request) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(
            e.getCode(),
            e.getMessage(),
            request.getRequestURI(),
            LocalDateTime.now().toString()
        );

        return new ResponseEntity<>(exceptionDTO, e.getHttpStatus());
    }
}
