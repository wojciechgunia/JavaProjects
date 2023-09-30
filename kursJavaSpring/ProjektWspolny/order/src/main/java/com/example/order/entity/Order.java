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
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(generator = "orders_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orders_id_seq",sequenceName = "orders_id_seq",allocationSize = 1)
    private long id;
    private String uuid;
    private String orders;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private String number;
    @Column(name = "postcode")
    private String postCode;
    private String client;
    @ManyToOne
    @JoinColumn(name = "deliver")
    private Deliver deliver;

}
