package com.om1cael.fryna.api.domain.repository;

import com.om1cael.fryna.api.domain.model.GroceryListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Long> {
}
