package com.familyApi.FamilyApiCleanCode.translator;

import com.familyApi.FamilyApiCleanCode.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorMemberDTOtoMemberDB
{
    public MemberDB toMemberDB(MemberDTO memberDTO)
    {
        return toMemberDBMap(memberDTO);
    }

    public MemberDB toMemberDB(MemberExtendedDTO memberDTO)
    {
        return toMemberDBMap(memberDTO);
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "age",source = "age"),
            @Mapping(target = "gender",source = "gender"),
            @Mapping(target = "familyId",ignore = true)
    })
    protected abstract MemberDB toMemberDBMap(MemberDTO memberDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "age",source = "age"),
            @Mapping(target = "gender",source = "gender"),
            @Mapping(target = "familyId",expression = "java(toFamilyDBMap(memberDTO.getFamily()))")
    })
    protected abstract MemberDB toMemberDBMap(MemberExtendedDTO memberDTO);

    @Mappings({
            @Mapping(target = "name",source = "name")
    })
    protected abstract FamilyDB toFamilyDBMap(FamilyDTO familyDTO);
}
