package com.familyApi.FamilyApiCleanCode.mediator;

import com.familyApi.FamilyApiCleanCode.model.*;
import com.familyApi.FamilyApiCleanCode.services.FamilyService;
import com.familyApi.FamilyApiCleanCode.services.MemberService;
import com.familyApi.FamilyApiCleanCode.translator.TranslatorFamilyDBtoFamilyDTO;
import com.familyApi.FamilyApiCleanCode.translator.TranslatorFamilyDTOtoFamilyDB;
import com.familyApi.FamilyApiCleanCode.translator.TranslatorMemberDBToMemberDTO;
import com.familyApi.FamilyApiCleanCode.translator.TranslatorMemberDTOtoMemberDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mediator
{
    public Mediator(TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO, TranslatorMemberDBToMemberDTO translatorMemberDBToMemberDTO, TranslatorFamilyDTOtoFamilyDB translatorFamilyDTOtoFamilyDB, TranslatorMemberDTOtoMemberDB translatorMemberDTOtoMemberDB, FamilyService familyService, MemberService memberService)
    {
        this.translatorFamilyDBtoFamilyDTO = translatorFamilyDBtoFamilyDTO;
        this.translatorMemberDBToMemberDTO = translatorMemberDBToMemberDTO;
        this.translatorFamilyDTOtoFamilyDB = translatorFamilyDTOtoFamilyDB;
        this.translatorMemberDTOtoMemberDB = translatorMemberDTOtoMemberDB;
        this.familyService = familyService;
        this.memberService = memberService;

    }

    TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO;
    TranslatorMemberDBToMemberDTO translatorMemberDBToMemberDTO;
    TranslatorFamilyDTOtoFamilyDB translatorFamilyDTOtoFamilyDB;
    TranslatorMemberDTOtoMemberDB translatorMemberDTOtoMemberDB;
    FamilyService familyService;
    MemberService memberService;

    public void saveFamily(FamilyDTO familyDTO)
    {
        FamilyDB familyDB = translatorFamilyDTOtoFamilyDB.toFamilyDB(familyDTO);
        familyService.save(familyDB);
    }

    public List<FamilyDTO> getByFamilyName(String name)
    {
        List<FamilyDB> list = familyService.getByName(name);
        List<FamilyDTO> dtolist = new ArrayList<>();
        for(FamilyDB familyDB:list)
        {
            dtolist.add(translatorFamilyDBtoFamilyDTO.toFamily(familyDB));
        }
        return dtolist;
    }

    public List<FamilyDTO> getAllFamily()
    {
        List<FamilyDB> list = familyService.getAll();
        List<FamilyDTO> dtolist = new ArrayList<>();
        for(FamilyDB familyDB:list)
        {
            dtolist.add(translatorFamilyDBtoFamilyDTO.toFamily(familyDB));
        }
        return dtolist;
    }

    public void saveMember(MemberDTO memberDTO)
    {
        MemberDB memberDB = translatorMemberDTOtoMemberDB.toMemberDB(memberDTO);
        memberService.save(memberDB);
    }

    public void updateMember(MemberExtendedDTO memberDTO)
    {
        MemberDB memberDB = translatorMemberDTOtoMemberDB.toMemberDB(memberDTO);
        memberService.save(memberDB);
    }


    public List<MemberExtendedDTO> getByMemberName(String name)
    {
        List<MemberDB> list = memberService.getMemberDBByName(name);
        List<MemberExtendedDTO> dtolist = new ArrayList<>();
        for(MemberDB memberDB:list)
        {
            dtolist.add(translatorMemberDBToMemberDTO.toMemberExtendedDTO(memberDB));
        }
        return dtolist;
    }

    public List<MemberExtendedDTO> getAllMember()
    {
        List<MemberDB> list = memberService.getMemberDBAll();
        List<MemberExtendedDTO> dtolist = new ArrayList<>();
        for(MemberDB memberDB:list)
        {
            dtolist.add(translatorMemberDBToMemberDTO.toMemberExtendedDTO(memberDB));
        }
        return dtolist;
    }
}
