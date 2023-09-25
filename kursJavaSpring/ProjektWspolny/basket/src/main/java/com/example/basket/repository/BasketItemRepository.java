package com.example.basket.repository;

import com.example.basket.entity.Basket;
import com.example.basket.entity.BasketItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItems, Long>
{

}
