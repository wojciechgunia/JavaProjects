package com.example.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO
{
    private String uuid;
    private String orders;
    private Status status;
    private CustomerDetails customerDetails;
    private Address address;
    private DeliverDTO deliver;
    private List<Items> items;
    private double summaryPrice;
}
