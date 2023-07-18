package com.familyApi.FamilyApiCleanCode.services;

import com.familyApi.FamilyApiCleanCode.model.Gender;
import com.familyApi.FamilyApiCleanCode.model.MemberDB;
import com.familyApi.FamilyApiCleanCode.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService
{
    public MemberService(MemberRepository memberRepository){this.memberRepository = memberRepository;}
    MemberRepository memberRepository;

    public void save(MemberDB memberDB) {memberRepository.save(memberDB);}

    public List<MemberDB> getMemberDBByName(String name)
    {
        return (List<MemberDB>) memberRepository.findByName(name);
    }
    public List<MemberDB> getMemberDBByAge(int age)
    {
        return (List<MemberDB>) memberRepository.findByAge(age);
    }
    public List<MemberDB> getMemberDBByGender(Gender gender)
    {
        return (List<MemberDB>) memberRepository.findByGender(gender);
    }

    public List<MemberDB> getMemberDBAll()
    {
        return (List<MemberDB>) memberRepository.findAll();
    }
}
