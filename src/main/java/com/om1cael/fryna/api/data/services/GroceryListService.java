package com.om1cael.fryna.api.data.services;

import com.om1cael.fryna.api.data.dtos.GroceryListDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListItemResponseDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListResponseDTO;
import com.om1cael.fryna.api.data.repositories.GroceryListRepository;
import com.om1cael.fryna.api.domain.models.GroceryList;
import com.om1cael.fryna.api.domain.models.GroceryListItem;
import com.om1cael.fryna.api.infra.exceptions.GroceryListException;
import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {
    @Autowired
    private GroceryListRepository repository;

    public GroceryListResponseDTO create(GroceryListDTO groceryListDTO) {
        GroceryList groceryList = new GroceryList();
        groceryList.setName(groceryListDTO.name());

        repository.save(groceryList);
        return toResponseDTO(groceryList);
    }

    public GroceryListResponseDTO getById(Long id) {
        Optional<GroceryList> groceryList = repository.findById(id);
        if(groceryList.isEmpty()) throw new GroceryListException(GroceryListErrors.NOT_FOUND);

        return toResponseDTO(groceryList.get());
    }

    private GroceryListResponseDTO toResponseDTO(GroceryList groceryList) {
        List<GroceryListItemResponseDTO> groceryListItems =
            groceryList.getItems().stream()
                .map(item -> new GroceryListItemResponseDTO(
                    item.getId(),
                    item.getName(),
                    item.getQuantity(),
                    item.isBought()
                ))
                .toList();

        return new GroceryListResponseDTO(
            groceryList.getId(),
            groceryList.getName(),
            groceryListItems
        );
    }
}
