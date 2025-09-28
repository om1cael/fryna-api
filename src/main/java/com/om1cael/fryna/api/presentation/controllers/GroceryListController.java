package com.om1cael.fryna.api.presentation.controllers;

import com.om1cael.fryna.api.data.dtos.GroceryListDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListResponseDTO;
import com.om1cael.fryna.api.data.services.GroceryListService;
import com.om1cael.fryna.api.domain.models.GroceryList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/list")
public class GroceryListController {
    @Autowired
    private GroceryListService service;

    @PostMapping
    private ResponseEntity<GroceryListResponseDTO> create(@RequestBody @Valid GroceryListDTO groceryListDTO) {
        GroceryListResponseDTO groceryList = service.create(groceryListDTO);
        return new ResponseEntity<>(groceryList, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<GroceryListResponseDTO> getById(@PathVariable(value = "id") Long id) {
        GroceryListResponseDTO groceryList = service.getById(id);
        return ResponseEntity.ok(groceryList);
    }
}
