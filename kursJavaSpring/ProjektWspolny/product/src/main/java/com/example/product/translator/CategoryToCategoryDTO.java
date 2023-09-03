package com.example.product.translator;

import com.example.product.entity.Category;
import com.example.product.entity.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper
public abstract class CategoryToCategoryDTO
{
    public CategoryDTO toCategoryDTO(Category category)
    {
        return toDTO(category);
    }

    @Mappings({})
    protected abstract CategoryDTO toDTO(Category category);
}
