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
public class Basket
{
    @Id
    @GeneratedValue(generator = "basket_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "basket_id_seq",sequenceName = "basket_id_seq",allocationSize = 1)
    private long id;

    private String uuid;
}
