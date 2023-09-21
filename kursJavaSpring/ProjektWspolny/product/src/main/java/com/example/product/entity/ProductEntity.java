package com.example.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductEntity extends Product
{
    @Id
    @GeneratedValue(generator = "products_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "products_id_seq",sequenceName = "products_id_seq", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_parameters")
    private Category category;

    public ProductEntity(long id, String uid, boolean activate, String name, String mainDesc, String descHtml, float price, String[] imageUrls, String parameters, LocalDate createAt, Category category)
    {
        super(uid, activate, name, mainDesc, descHtml, price, imageUrls, parameters, createAt);
        this.id = id;
        this.category=category;
    }
}
