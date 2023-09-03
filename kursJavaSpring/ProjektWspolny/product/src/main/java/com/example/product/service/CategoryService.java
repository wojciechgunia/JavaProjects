package com.example.product.service;

import com.example.product.entity.Category;
import com.example.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public List<Category> getCategory()
    {
        return categoryRepository.findAll();
    }
}
