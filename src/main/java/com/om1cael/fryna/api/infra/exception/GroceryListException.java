package com.om1cael.fryna.api.infra.exception;

import com.om1cael.fryna.api.infra.exception.enums.GroceryListErrors;

public class GroceryListException extends ApiException {
    public GroceryListException(GroceryListErrors error) {
        super(error.getMessage(), error.getCode(), error.getHttpStatus());
    }
}
