package com.familyApi.FamilyApiCleanCode.translator;

import com.familyApi.FamilyApiCleanCode.model.FamilyDB;
import com.familyApi.FamilyApiCleanCode.model.FamilyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorFamilyDTOtoFamilyDB
{
    public FamilyDB toFamilyDB(FamilyDTO familyDTO)
    {
        FamilyDB familyDB = toFamilyDBMap(familyDTO);
        return familyDB;
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name",source = "name")
    })
    protected abstract FamilyDB toFamilyDBMap(FamilyDTO familyDTO);
}
