package com.om1cael.fryna.api.presentation.controllers.exception;

import com.om1cael.fryna.api.data.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ExceptionDTO> entityNotFound(EntityNotFoundException e) {
        return new ResponseEntity<>(new ExceptionDTO(false, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ExceptionDTO> constraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(new ExceptionDTO(false, "Size Violation"), HttpStatus.NOT_FOUND);
    }
}
