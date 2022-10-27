package com.example.test.repository;

import com.example.test.infrastructure.reponse.StatusId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatusIdRepository extends JpaRepository<StatusId,Long> {
    @Query(value = "SELECT id FROM db_test.status " +
            "where status_name = :status_name",nativeQuery = true)
    Long getbyId(@Param("status_name") String status_name);
}
