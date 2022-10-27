package com.example.test.repository;

import com.example.test.infrastructure.reponse.SubCategoryId;
import com.example.test.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubCategoryRepository extends JpaRepository<SubCategoryId,Long> {

    @Query(value = "SELECT id FROM db_test.sub_category " +
            "where sub_cate_name = :sub_cate_name limit 1",nativeQuery = true)
     Long getbyId(@Param("sub_cate_name") String sub_cate_name);

}
