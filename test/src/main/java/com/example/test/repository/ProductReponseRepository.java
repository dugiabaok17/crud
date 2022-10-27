package com.example.test.repository;

import com.example.test.infrastructure.reponse.ProductReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReponseRepository extends JpaRepository<ProductReponse, Long> {
    @Query(value = "select product_id as id,product_name,color,quantity,sell_price,origin_price,brand_name,sub_cate_name,status_name from db_test.product  \n" +
            "            left join db_test.sub_category on product.subcate_id = sub_category.id\n" +
            "            left join db_test.status on status.id = product.status_id\n" +
            "            join db_test.product_brand on product_brand.product_id = product.id\n" +
            "            join brand on brand.id = product_brand.brand_id order by product.date_created desc", countQuery = "\n" +
            "select count(*) from db_test.product  \n" +
            "            left join db_test.sub_category on product.subcate_id = sub_category.id\n" +
            "                                        left join db_test.status on status.id = product.status_id\n" +
            "                                         join db_test.product_brand on product_brand.product_id = product.id\n" +
            "                                          join brand on brand.id = product_brand.brand_id ", nativeQuery = true)
    Page<ProductReponse> getList(Pageable pageable);
//    Page<ProductReponse> getList(Pageable pageable);


    @Query(value = "select product_id as id,product_name,color,quantity,sell_price,origin_price,brand_name,sub_cate_name,status_name from db_test.product  \n" +
            "            left join db_test.sub_category on product.subcate_id = sub_category.id\n" +
            "            left join db_test.status on status.id = product.status_id\n" +
            "            join db_test.product_brand on product_brand.product_id = product.id\n" +
            "            join brand on brand.id = product_brand.brand_id where db_test.product.id = :id", nativeQuery = true)
    ProductReponse getByProductId(@Param("id") Long id);

}
