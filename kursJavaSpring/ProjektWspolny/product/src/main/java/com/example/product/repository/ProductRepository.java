package com.example.product.repository;

import com.example.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    @Query(nativeQuery = true, value = "SELECT count(*) FROM products WHERE activate is TRUE")
    long countActiveProducts();

    List<ProductEntity> findByNameAndCreateAt(String name, LocalDate date);
}