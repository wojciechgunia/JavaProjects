package com.familyApi.FamilyApiCleanCode.repository;

import com.familyApi.FamilyApiCleanCode.model.Gender;
import com.familyApi.FamilyApiCleanCode.model.MemberDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDB,Long>
{
    Iterable<MemberDB> findByName(String name);
    Iterable<MemberDB> findByAge(int age);
    Iterable<MemberDB> findByGender(Gender gender);
}
