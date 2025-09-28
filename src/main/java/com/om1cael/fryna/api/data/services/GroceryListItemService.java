package com.om1cael.fryna.api.data.services;

import com.om1cael.fryna.api.data.dtos.GroceryListDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListItemDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListItemResponseDTO;
import com.om1cael.fryna.api.data.repositories.GroceryListItemRepository;
import com.om1cael.fryna.api.data.repositories.GroceryListRepository;
import com.om1cael.fryna.api.domain.models.GroceryList;
import com.om1cael.fryna.api.domain.models.GroceryListItem;
import com.om1cael.fryna.api.infra.exceptions.GroceryListException;
import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroceryListItemService {
    @Autowired
    private GroceryListRepository groceryListRepository;

    @Autowired
    private GroceryListItemRepository repository;

    public GroceryListItemResponseDTO create(GroceryListItemDTO dto) {
        GroceryListItem groceryListItem = new GroceryListItem();
        GroceryList groceryList = groceryListRepository
                .findById(dto.listID())
                .orElseThrow(() -> new GroceryListException(GroceryListErrors.NOT_FOUND));

        groceryListItem.setName(dto.name());
        groceryListItem.setQuantity(dto.quantity());
        groceryListItem.setBought(dto.bought());
        groceryListItem.setGroceryList(groceryList);

        repository.save(groceryListItem);
        return toDTO(groceryListItem);
    }

    private GroceryListItemResponseDTO toDTO(GroceryListItem groceryListItem) {
        return new GroceryListItemResponseDTO(
            groceryListItem.getId(),
            groceryListItem.getName(),
            groceryListItem.getQuantity(),
            groceryListItem.isBought()
        );
    }
}
