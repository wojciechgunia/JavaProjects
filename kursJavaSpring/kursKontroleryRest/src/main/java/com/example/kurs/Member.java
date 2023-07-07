package com.example.kurs;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member
{
    private String name;
    private int age;
    private String gender;
}
