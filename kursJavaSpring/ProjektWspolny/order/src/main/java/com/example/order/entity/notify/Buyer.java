package com.example.order.entity.notify;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer
{
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String language;
}
