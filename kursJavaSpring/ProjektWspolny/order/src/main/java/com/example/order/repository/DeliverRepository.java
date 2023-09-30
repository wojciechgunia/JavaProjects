package com.example.order.repository;

import com.example.order.entity.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliverRepository extends JpaRepository<Deliver, Long>
{
    Optional<Deliver> findByUuid(String uuid);
}
