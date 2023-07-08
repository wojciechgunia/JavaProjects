package com.example.kurs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDB,Long>
{
    Optional<FamilyDB> findById(Long id);

    Iterable<FamilyDB> findByName(String Name);

    @Query(value = "SELECT * FROM family where name=?1",nativeQuery = true)
    List<FamilyDB> findListByName(String name);

}


