package com.om1cael.fryna.api.infra.exceptions.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum GroceryListItemsErrors {
    NOT_FOUND(800, "Grocery list item not found", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;

    GroceryListItemsErrors(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
