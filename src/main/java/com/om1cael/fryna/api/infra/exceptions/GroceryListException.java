package com.om1cael.fryna.api.infra.exceptions;

import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListErrors;

public class GroceryListException extends ApiException {
    public GroceryListException(GroceryListErrors error) {
        super(error.getMessage(), error.getCode(), error.getHttpStatus());
    }
}
