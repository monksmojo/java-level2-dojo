package com.legoStore.springBootmongo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvgRatingModel {
    private String id;
    private String productName;
    private double avgRating;

    public AvgRatingModel(String id, String productName, double avdRating) {
        this.id = id;
        this.productName = productName;
        this.avgRating = avdRating;
    }
}
