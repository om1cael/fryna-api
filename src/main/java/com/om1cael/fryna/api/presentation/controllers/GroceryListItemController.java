package com.om1cael.fryna.api.presentation.controllers;

import com.om1cael.fryna.api.data.dtos.GroceryListItemDTO;
import com.om1cael.fryna.api.data.dtos.GroceryListItemResponseDTO;
import com.om1cael.fryna.api.data.services.GroceryListItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/list/{id}/items")
public class GroceryListItemController {
    @Autowired
    private GroceryListItemService service;

    @PostMapping
    public ResponseEntity<GroceryListItemResponseDTO> create(@PathVariable(value = "id") Long id, @Valid @RequestBody GroceryListItemDTO dto) {
        GroceryListItemResponseDTO responseDTO = service.create(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
