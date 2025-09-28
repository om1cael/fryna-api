package com.om1cael.fryna.api.data.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GroceryListItemDTO(
    @Size(min = 1, max = 32)
    @NotNull
    String name,

    @Min(1)
    @Max(64)
    @NotNull
    int quantity,

    @NotNull
    boolean bought,

    @NotNull
    int listID
) {
}
