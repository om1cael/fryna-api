package com.om1cael.fryna.api.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL)
    private List<GroceryListItem> items;
}
