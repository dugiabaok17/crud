package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "origin_price")
    private Double originPrice;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcate_id",nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "status_id",nullable = false)
    private Status status;

    @ManyToMany(mappedBy = "listProduct",cascade = CascadeType.ALL)
    private Set<Brand> brandList;



}
