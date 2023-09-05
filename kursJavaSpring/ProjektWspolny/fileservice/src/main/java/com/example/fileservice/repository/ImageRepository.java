package com.example.fileservice.repository;

import com.example.fileservice.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long>
{
    Optional<ImageEntity> findByUid(String uid);
}
