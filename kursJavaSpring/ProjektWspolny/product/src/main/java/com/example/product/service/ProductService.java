package com.example.product.service;

import com.example.product.entity.ProductDTO;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;

    public long countActiveProducts(){
        return productRepository.countActiveProducts();
    }
    public ProductDTO getProductDTO()
    {
        return null;
    }
}
