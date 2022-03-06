package com.legoStore.springBootmongo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReview {

    private String userName;
    private Double rating;

    public ProductReview(String userName, Double rating) {
        this.userName = userName;
        this.rating = rating;
    }
}
