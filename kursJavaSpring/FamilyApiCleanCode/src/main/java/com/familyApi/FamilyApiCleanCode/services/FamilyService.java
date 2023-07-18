package com.familyApi.FamilyApiCleanCode.services;

import com.familyApi.FamilyApiCleanCode.model.FamilyDB;
import com.familyApi.FamilyApiCleanCode.repository.FamilyRepository;
import com.familyApi.FamilyApiCleanCode.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService
{

    public FamilyService(FamilyRepository familyRepository) {this.familyRepository = familyRepository;}
    FamilyRepository familyRepository;

    public void save(FamilyDB familyDB) {familyRepository.save(familyDB);}

    public List<FamilyDB> findByName(String name)
    {
        return (List<FamilyDB>) familyRepository.findByName(name);
    }

    public List<FamilyDB> getByName(String name)
    {
        return (List<FamilyDB>) familyRepository.findByName(name);
    }

    public List<FamilyDB> getAll()
    {
        return (List<FamilyDB>) familyRepository.findAll();
    }
}
