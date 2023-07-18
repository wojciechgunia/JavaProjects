package com.familyApi.FamilyApiCleanCode.facade;

import com.familyApi.FamilyApiCleanCode.model.FamilyDB;
import com.familyApi.FamilyApiCleanCode.model.Gender;
import com.familyApi.FamilyApiCleanCode.model.MemberDB;
import com.familyApi.FamilyApiCleanCode.model.MemberExtendedDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.familyApi.FamilyApiCleanCode.translator.TranslatorMemberDBToMemberDTO;

@RestController
public class FamilyController {

    @Autowired
    TranslatorMemberDBToMemberDTO translatorMemberDBToMemberDTO;

    @GetMapping("/test")
    public MemberExtendedDTO test()
    {
        FamilyDB familyDB = new FamilyDB(1, "Nowak");
        MemberDB memberDB = new MemberDB(1,"Tomek",12, Gender.M, familyDB);
        return translatorMemberDBToMemberDTO.toMemberExtendedDTO(memberDB);
    }
    public void saveFamily()
    {

    }

    public void getFamilyByParam()
    {

    }

    public void getAllFamily()
    {

    }
}
