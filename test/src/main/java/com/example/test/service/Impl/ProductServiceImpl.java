package com.example.test.service.Impl;

import com.example.test.infrastructure.reponse.ProductReponse;
import com.example.test.infrastructure.request.ProductRequest;
import com.example.test.model.Brand;
import com.example.test.model.Product;
import com.example.test.model.Status;
import com.example.test.model.SubCategory;
import com.example.test.repository.*;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductReponseRepository productReponseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private StatusIdRepository statusRepository;

    @Override
    public Page<ProductReponse> getList(Pageable pageable) {
        return productReponseRepository.getList(pageable);
    }

    @Override
    public Brand insert(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setQuantity(productRequest.getQuantity());
        product.setColor(productRequest.getColor());
        product.setOriginPrice(productRequest.getOriginPrice());
        product.setSellPrice(productRequest.getSellPrice());

        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryRepository.getbyId(productRequest.getSubCateName()));
        product.setSubCategory(subCategory);

        Set<Product> list = new HashSet<>();
        list.add(product);
        productRepository.save(product);
        Brand brand = new Brand();
        brand.setId(brandRepository.getbyId(productRequest.getBrandName()));
        brand.setBrandName(productRequest.getBrandName());
        brand.setListProduct(list);
        return brandRepository.save(brand);
    }

    @Override
    public String update(Long id,ProductRequest productRequest) {
        Optional<Product> updateProduct = Optional.ofNullable(productRepository.getByIdd(id));
        if (!updateProduct.isPresent()){
            System.out.println(id);
            return "Product không tồn tại ";
        }
        updateProduct.get().setProductName(productRequest.getProductName());
        updateProduct.get().setColor(productRequest.getColor());
        updateProduct.get().setQuantity(productRequest.getQuantity());
        updateProduct.get().setSellPrice(productRequest.getSellPrice());
        updateProduct.get().setOriginPrice(productRequest.getSellPrice());

        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryRepository.getbyId(productRequest.getSubCateName()));
        updateProduct.get().setSubCategory(subCategory);

        Status status = new Status();
        status.setId(statusRepository.getbyId(productRequest.getStatusName()));
        updateProduct.get().setStatus(status);


        Set<Product> list = new HashSet<>();


        list.add(updateProduct.get());
        productRepository.save(updateProduct.get());
        Brand brand = new Brand();
        brand.setId(brandRepository.getbyId(productRequest.getBrandName()));
        brand.setBrandName(productRequest.getBrandName());
        brand.setListProduct(list);
        brandRepository.save(brand);
        return "update sucessfully";
    }
    
}
