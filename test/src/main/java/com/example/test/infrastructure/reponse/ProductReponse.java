package com.example.test.infrastructure.reponse;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ProductReponse {
    @Id
    private Long id;
    private String subCateName;
    private String productName;
    private String color;
    private Long quantity;
    private Double sellPrice;
    private Double originPrice;
    private String statusName;
    private String brandName;
}
