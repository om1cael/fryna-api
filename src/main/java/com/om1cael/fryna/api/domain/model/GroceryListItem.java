package com.om1cael.fryna.api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroceryListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 32)
    @NotNull
    private String name;

    @Min(1)
    @Max(64)
    @NotNull
    private int quantity;

    @NotNull
    private boolean bought;

    @ManyToOne
    @JoinColumn(name = "grocery_list_id", nullable = false)
    private GroceryList groceryList;
}
