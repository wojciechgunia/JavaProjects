package com.familyApi.FamilyApiCleanCode.repository;

import com.familyApi.FamilyApiCleanCode.model.FamilyDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDB, Long>
{

}
