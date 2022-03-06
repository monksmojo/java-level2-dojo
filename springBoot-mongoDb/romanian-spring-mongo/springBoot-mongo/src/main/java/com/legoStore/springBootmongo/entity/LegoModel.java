package com.legoStore.springBootmongo.entity;

import com.mysema.query.annotations.QueryEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Getter
@Setter

@Document(collection = "LegoModel")
public class LegoModel {
    @Id
    private String id;


    private String name;

    @Field(name = "difficulty_mode")
    private Difficulty difficultyMode;


    @Indexed(direction = IndexDirection.ASCENDING)
    private String theme;

    @Field(name = "delivery_info")
    private DeliveryInfo deliveryInfo;

    private Collection<ProductReview> productReviews;

    public LegoModel(String name, Difficulty difficultyMode,
                     String theme, DeliveryInfo deliveryInfo,
                     Collection<ProductReview> productReviews) {
        this.name = name;
        this.difficultyMode = difficultyMode;
        this.theme = theme;
        this.deliveryInfo = deliveryInfo;
        if(productReviews!=null){
            this.productReviews = productReviews;
        }
    }
}
