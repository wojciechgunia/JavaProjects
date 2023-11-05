package com.example.order.repository;

import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>
{
    Optional<Order> findOrderByOrders(String orders);

    List<Order> findOrderByClient(String login);

    Optional<Order> findOrderByUuid(String uuid);
}
