package com.example.product.fasade;

import com.example.product.entity.CategoryDTO;
import com.example.product.entity.Response;
import com.example.product.exceptions.ObjectExistInDBException;
import com.example.product.mediator.CategoryMediator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController
{
    private final CategoryMediator categoryMediator;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> getCategory()
    {
        return categoryMediator.getCategory();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        try
        {
            categoryMediator.createCategory(categoryDTO);
        }
        catch (ObjectExistInDBException e)
        {
            return ResponseEntity.status(400).body(new Response("Category exist with this name"));
        }
        return ResponseEntity.ok(new Response("Operation end Success"));
    }
}
