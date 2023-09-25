package com.example.basket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BasketItems
{
    @Id
    @GeneratedValue(generator = "basket_items_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "basket_items_id_seq",sequenceName = "basket_items_id_seq",allocationSize = 1)
    private long id;

    private String uuid;

    private String product;

    @ManyToOne
    @JoinColumn(name="basket")
    private Basket basket;

    private long quantity;
}
