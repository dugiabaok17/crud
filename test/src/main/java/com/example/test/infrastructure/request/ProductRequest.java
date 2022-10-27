package com.example.test.infrastructure.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {



    @NotBlank(message = "subCateName can not blank")
    private String subCateName;

    @NotBlank(message = "productName can not blank")
    private String productName;

    @NotBlank(message = "color can not blank")
    private String color;

    @NotNull(message = "quantity can not blank")
    private Long quantity;

    @NotNull(message = "sellPrice can not blank")
    private Double sellPrice;

    @NotNull(message = "originPrice can not blank")
    private Double originPrice;

    @NotBlank(message = "brandName can not blank")
    private String brandName;


//    @NotBlank(message = "status can not blank")
    private String statusName;
}
