package com.example.kurs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class FamilyMapper
{
    @Mappings({
        @Mapping(target = "uid", expression = "java(getUid(familyDB.getId()))"),
        @Mapping(target = "name", source = "name"),
    })
    public abstract Family FamilyDbToFamily(FamilyDB familyDB);

    public String getUid(long id)
    {
        return Long.toString(id);
    }
}
