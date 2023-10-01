package com.example.order.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayUProduct
{
    private String name;
    private long unitPrice;
    private long quantity;
}
