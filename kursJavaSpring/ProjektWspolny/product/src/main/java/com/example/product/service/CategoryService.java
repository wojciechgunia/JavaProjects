package com.example.product.service;

import com.example.product.entity.Category;
import com.example.product.entity.CategoryDTO;
import com.example.product.exceptions.ObjectExistInDBException;
import com.example.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public List<Category> getCategory()
    {
        return categoryRepository.findAll();
    }

    public void create(CategoryDTO categoryDTO) throws ObjectExistInDBException
    {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setShortId(UUID.randomUUID().toString().replace("-","").substring(0,12));

        categoryRepository.findByName(category.getName()).ifPresent(value -> {
            throw new ObjectExistInDBException("Category exist with this name");
        });
        categoryRepository.save(category);
    }

    public Optional<Category> findCategoryByShortID(String shortId)
    {
        return categoryRepository.findByShortId(shortId);
    }
}
