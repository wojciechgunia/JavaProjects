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
    private String descHtml;
    private float price;
    private String[] imagesUid;
    private String parameters;
    private String category;
}
