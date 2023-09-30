package com.example.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDetails
{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
