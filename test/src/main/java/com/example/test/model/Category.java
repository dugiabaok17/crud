package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cate_code")
    private String cateCode;

    @Column(name = "cate_name")
    private String cateName;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<SubCategory> listSubcategory;
}
