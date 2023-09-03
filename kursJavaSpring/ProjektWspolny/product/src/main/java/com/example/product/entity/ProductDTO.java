package com.example.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends Product
{
    private CategoryDTO categoryDTO;

    public ProductDTO(String uid, boolean activate, String name, String mainDesc, String descHtml, float price, String[] imageUrls, String parameters, LocalDate createAt, CategoryDTO categoryDTO)
    {
        super(uid, activate, name, mainDesc, descHtml, price, imageUrls, parameters, createAt);
        this.categoryDTO=categoryDTO;
    }
}
