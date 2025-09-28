package com.om1cael.fryna.api.data.services;

import com.om1cael.fryna.api.data.dtos.GroceryListDTO;
import com.om1cael.fryna.api.data.repositories.GroceryListRepository;
import com.om1cael.fryna.api.domain.models.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListService {
    @Autowired
    private GroceryListRepository repository;

    public boolean create(GroceryListDTO groceryListDTO) {
        GroceryList groceryList = new GroceryList();
        groceryList.setName(groceryListDTO.name());

        repository.save(groceryList);
        return true;
    }

    public List<GroceryList> getAll() {
        return repository.findAll();
    }
}
