package com.example.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormDTO
{
    private String name;
    private String mainDesc;
    private String descHTML;
    private float price;
    private String[] imageUrls;
    private String parameters;
    private String category;
}
