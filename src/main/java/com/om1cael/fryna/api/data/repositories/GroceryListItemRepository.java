package com.om1cael.fryna.api.data.repositories;

import com.om1cael.fryna.api.domain.models.GroceryListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Long> {
}
