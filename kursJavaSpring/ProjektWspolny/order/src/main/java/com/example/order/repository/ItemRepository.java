package com.example.order.repository;

import com.example.order.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<OrderItems, Long>
{
}
