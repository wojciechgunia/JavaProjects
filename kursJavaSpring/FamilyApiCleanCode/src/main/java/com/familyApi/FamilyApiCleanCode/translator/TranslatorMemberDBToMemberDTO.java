package com.familyApi.FamilyApiCleanCode.translator;

import com.familyApi.FamilyApiCleanCode.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorMemberDBToMemberDTO {

    public MemberDTO toMemberDTO(MemberDB memberDB){
        MemberDTO memberDTO = toDTO(memberDB);
        return memberDTO;

    }
    public MemberExtendedDTO toMemberExtendedDTO(MemberDB memberDB){
        MemberExtendedDTO memberDTO = toExtendedDTO(memberDB);
        return memberDTO;
    }


    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "age",target = "age"),
            @Mapping(source = "gender",target = "gender")
    })
    protected abstract MemberDTO toDTO(MemberDB memberDB);
    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "age",target = "age"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(expression = "java(toFamilyDTODTO(memberDB.getFamilyId()))",target = "family")
    })
    protected abstract MemberExtendedDTO toExtendedDTO(MemberDB memberDB);

    @Mappings({
            @Mapping(source = "name",target = "name"),
    })
    protected abstract FamilyDTO toFamilyDTODTO(FamilyDB familyDB);
}
