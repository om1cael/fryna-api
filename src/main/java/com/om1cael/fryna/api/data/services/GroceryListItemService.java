package com.om1cael.fryna.api.data.services;

import com.om1cael.fryna.api.data.dtos.GroceryListItemDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListItemResponseDTO;
import com.om1cael.fryna.api.data.repositories.GroceryListItemRepository;
import com.om1cael.fryna.api.data.repositories.GroceryListRepository;
import com.om1cael.fryna.api.domain.models.GroceryList;
import com.om1cael.fryna.api.domain.models.GroceryListItem;
import com.om1cael.fryna.api.infra.exceptions.GroceryListException;
import com.om1cael.fryna.api.infra.exceptions.GroceryListItemException;
import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListErrors;
import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListItemsErrors;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroceryListItemService {
    @Autowired
    private GroceryListRepository groceryListRepository;

    @Autowired
    private GroceryListItemRepository repository;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GroceryListItemResponseDTO create(Long id, GroceryListItemDTO dto) {
        GroceryListItem groceryListItem = new GroceryListItem();
        GroceryList groceryList = groceryListRepository
                .findById(id)
                .orElseThrow(() -> new GroceryListException(GroceryListErrors.NOT_FOUND));

        groceryListItem.setName(dto.name());
        groceryListItem.setQuantity(dto.quantity());
        groceryListItem.setBought(dto.bought());
        groceryListItem.setGroceryList(groceryList);

        repository.save(groceryListItem);
        return toResponseDTO(groceryListItem);
    }

    public boolean delete(Long listId, Long itemId) {
        GroceryList groceryList = groceryListRepository
                .findById(listId)
                .orElseThrow(() -> new GroceryListException(GroceryListErrors.NOT_FOUND));

        GroceryListItem groceryListItem = groceryList
                .getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new GroceryListItemException(GroceryListItemsErrors.NOT_FOUND));

        groceryList.getItems().remove(groceryListItem);
        groceryListRepository.save(groceryList);
        return true;
    }

    private GroceryListItemResponseDTO toResponseDTO(GroceryListItem groceryListItem) {
        return new GroceryListItemResponseDTO(
            groceryListItem.getId(),
            groceryListItem.getName(),
            groceryListItem.getQuantity(),
            groceryListItem.isBought()
        );
    }
}
