package com.familyApi.FamilyApiCleanCode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO
{
    private String name;
    private int age;
    private Gender gender;
}
