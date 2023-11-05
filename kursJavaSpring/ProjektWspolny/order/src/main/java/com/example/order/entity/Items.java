package com.example.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items
{
    private String uuid;
    private String name;
    private String imageUrl;
    private long quantity;
    private double priceUnit;
    private double priceSummary;
}
