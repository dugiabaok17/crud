package com.example.test.repository;

import com.example.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Modifying
//    @Query(value = "insert into `db_test`.`product`\n" +
//            "(`sell_price`,\n" +
//            "`origin_price`,\n" +
//            "`color`,\n"+
//            "`quantity`,\n"+
//            "`subcate_id`,\n"+
//            "`product_name`)\n" +
//            "values (:sell_price,:origin_price,:color,:quantity,:subcate_id,:product_name); ", nativeQuery = true)
//
//    @Transactional
//    Integer hehes(@Param("sell_price") Double sell_price,
//                 @Param("origin_price") Double origin_price,
//                 @Param("color") String color,
//                 @Param("quantity") Long quantity,
//                 @Param("subcate_id") Long subcate_id,
//                 @Param("product_name") String product_name);
    @Query(value = "select id,color,description,product_name,quantity,sell_price,status_id,subcate_id,origin_price from product where id = :id",nativeQuery = true)
    Product getByIdd(@Param("id") Long id);

}
