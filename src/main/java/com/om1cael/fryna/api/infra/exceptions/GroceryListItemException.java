package com.om1cael.fryna.api.infra.exceptions;

import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListItemsErrors;

public class GroceryListItemException extends ApiException {
    public GroceryListItemException(GroceryListItemsErrors error) {
        super(error.getMessage(), error.getCode(), error.getHttpStatus());
    }
}
