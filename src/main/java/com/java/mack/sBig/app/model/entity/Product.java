package com.java.mack.sBig.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.mack.sBig.app.model.dto.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @Enumerated(EnumType.STRING)
    private ProductType type; // FOOD, DRINK

    private Long userId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Recipe> recipes = new ArrayList<>();
}
