package com.javaTechie.springmongoembedded.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String name;

    private Double price;

    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
