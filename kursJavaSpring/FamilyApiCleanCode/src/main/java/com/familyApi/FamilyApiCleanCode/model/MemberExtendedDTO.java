package com.familyApi.FamilyApiCleanCode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberExtendedDTO extends MemberDTO
{
    private FamilyDTO family_id;
}
