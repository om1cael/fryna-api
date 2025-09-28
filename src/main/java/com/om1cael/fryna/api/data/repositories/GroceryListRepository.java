package com.om1cael.fryna.api.data.repositories;

import com.om1cael.fryna.api.domain.models.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {
}
