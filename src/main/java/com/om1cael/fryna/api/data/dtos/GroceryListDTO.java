package com.om1cael.fryna.api.data.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GroceryListDTO (
       @NotNull @Size(min = 1, max = 64) String name
) {}
