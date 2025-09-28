package com.om1cael.fryna.api.domain.repository;

import com.om1cael.fryna.api.domain.model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {
}
