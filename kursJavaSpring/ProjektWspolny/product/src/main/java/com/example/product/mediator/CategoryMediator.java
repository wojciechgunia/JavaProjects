package com.example.product.mediator;

import com.example.product.entity.CategoryDTO;
import com.example.product.service.CategoryService;
import com.example.product.translator.CategoryToCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMediator
{
    private final CategoryService categoryService;
    private final CategoryToCategoryDTO categoryToCategoryDTO;
    public ResponseEntity<List<CategoryDTO>> getCategory()
    {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryService.getCategory().forEach(value -> {categoryDTOS.add(categoryToCategoryDTO.toCategoryDTO(value));});
        return ResponseEntity.ok(categoryDTOS);
    }
}
