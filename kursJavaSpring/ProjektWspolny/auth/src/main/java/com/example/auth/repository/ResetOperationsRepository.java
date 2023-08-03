package com.example.auth.repository;

import com.example.auth.entity.ResetOperations;
import com.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResetOperationsRepository extends JpaRepository<ResetOperations, Long>
{
    @Modifying
    void deleteByUser(User user);

    Optional<ResetOperations> findByUid(String uid);

    @Query(nativeQuery = true, value = "SELECT * FROM resetoperations WHERE createdate <= current_timestamp - INTERVAL '15 minutes'")
    List<ResetOperations> findExpiredOperations();


}
