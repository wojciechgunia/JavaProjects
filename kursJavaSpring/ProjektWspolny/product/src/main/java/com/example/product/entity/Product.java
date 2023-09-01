package com.example.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Product
{
    @Id
    @GeneratedValue(generator = "produkts_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "produkts_id_seq",sequenceName = "produkts_id_seq", allocationSize = 1)
    private long id;
    private String uid;
    private boolean activate;
    @Column(name = "product_name")
    private String name;
    private String mainDesc;
    private String descHtml;
    private float price;
    private String[] imageUrls;
    private String parameters;
    private LocalDate createAt;
}
