package com.example.basket.repository;

import com.example.basket.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long>
{

    Optional<Basket> findByUuid(String uuid);
}
