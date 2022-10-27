package com.example.test.repository;

import com.example.test.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    @Query(value = "SELECT id FROM db_test.brand " +
            "where brand_name = :brand_name limit 1",nativeQuery = true)
    Long getbyId(@Param("brand_name") String brand_name);


}
