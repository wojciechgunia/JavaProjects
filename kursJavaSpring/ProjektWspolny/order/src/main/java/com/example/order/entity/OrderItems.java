package com.example.order.entity;

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
public class OrderItems
{
    @Id
    @GeneratedValue(generator = "order_items_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_items_id_seq",sequenceName = "order_items_id_seq",allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name="orders")
    private Order order;
    private String product;
    private String uuid;
    private String name;
    private long quantity;
    @Column(name = "priceunit")
    private double priceUnit;
    @Column(name = "pricesummary")
    private double priceSummary;

}
