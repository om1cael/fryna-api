package com.om1cael.fryna.api.data.services;

import com.om1cael.fryna.api.data.dtos.GroceryListDTO;
import com.om1cael.fryna.api.data.repositories.GroceryListRepository;
import com.om1cael.fryna.api.domain.models.GroceryList;
import com.om1cael.fryna.api.infra.exceptions.GroceryListException;
import com.om1cael.fryna.api.infra.exceptions.enums.GroceryListErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {
    @Autowired
    private GroceryListRepository repository;

    public GroceryList create(GroceryListDTO groceryListDTO) {
        GroceryList groceryList = new GroceryList();
        groceryList.setName(groceryListDTO.name());

        return repository.save(groceryList);
    }

    public GroceryList getById(Long id) {
        Optional<GroceryList> groceryList = repository.findById(id);
        if(groceryList.isEmpty()) throw new GroceryListException(GroceryListErrors.NOT_FOUND);

        return groceryList.get();
    }
}
