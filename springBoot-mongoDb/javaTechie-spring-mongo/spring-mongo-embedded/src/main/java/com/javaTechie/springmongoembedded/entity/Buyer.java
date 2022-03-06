package com.javaTechie.springmongoembedded.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Buyer")
@Getter
@Setter
public class Buyer {
    @Id
    private Long buyerId;

    private String name;

    private String gender;

    private Address address;

    private List<Product> productList;

    public Buyer(Long buyerId, String name, String gender,
                 Address address, List<Product> productList) {
        this.buyerId = buyerId;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.productList = productList;
    }
}
