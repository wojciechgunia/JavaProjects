package com.example.kurs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member
{
    private String name;
    private int age;
    private String gender;
}
