package com.familyApi.FamilyApiCleanCode.model;

import lombok.*;

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
