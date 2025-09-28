package com.om1cael.fryna.api.infra.exceptions.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum GroceryListErrors {
    NOT_FOUND(700, "Grocery list not found", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;

    GroceryListErrors(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
