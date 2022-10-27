package com.example.test.service;

import com.example.test.infrastructure.reponse.ProductReponse;
import com.example.test.infrastructure.request.ProductRequest;
import com.example.test.model.Brand;
import com.example.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductReponse> getList(Pageable pageable);
    Brand insert(ProductRequest productRequest);
    String update(Long id,ProductRequest productRequest);
}
