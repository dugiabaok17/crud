package com.example.test.infrastructure.reponse;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SubCategoryId {
    @Id
    private Long id;
}
