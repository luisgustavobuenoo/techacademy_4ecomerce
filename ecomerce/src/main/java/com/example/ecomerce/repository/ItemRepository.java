package com.example.ecomerce.repository;

import com.example.ecomerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
