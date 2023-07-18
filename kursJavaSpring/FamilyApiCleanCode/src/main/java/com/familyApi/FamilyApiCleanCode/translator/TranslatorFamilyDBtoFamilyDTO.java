package com.familyApi.FamilyApiCleanCode.translator;

import com.familyApi.FamilyApiCleanCode.model.FamilyDB;
import com.familyApi.FamilyApiCleanCode.model.FamilyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorFamilyDBtoFamilyDTO
{

    public FamilyDTO toFamily(FamilyDB familyDB)
    {
        FamilyDTO familyDTO = toFamilyDTO(familyDB);
        return familyDTO;
    }

    @Mappings({
            @Mapping(source = "name", target = "name"),
    })
    protected abstract FamilyDTO toFamilyDTO(FamilyDB familyDB);

}
