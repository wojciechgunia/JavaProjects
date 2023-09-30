package com.example.order.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Deliver
{
    @Id
    @GeneratedValue(generator = "deliver_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "deliver_id_seq",sequenceName = "deliver_id_seq",allocationSize = 1)
    private long id;
    private String uuid;
    private String name;
    private double price;
}
