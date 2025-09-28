package com.om1cael.fryna.api.data.dtos;
public record GroceryListItemResponseDTO(
    Long id,
    String name,
    int quantity,
    boolean bought
) {
}
