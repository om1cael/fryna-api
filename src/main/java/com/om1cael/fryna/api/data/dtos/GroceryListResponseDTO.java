package com.om1cael.fryna.api.data.dtos;

import java.util.List;

public record GroceryListResponseDTO(
        Long id,
        String name,
        List<GroceryListItemResponseDTO> items
) {}
