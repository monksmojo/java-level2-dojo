package com.legoStore.springBootmongo.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DeliveryInfo {
    private LocalDate deliveryDate;
    private Double deliveryFee;
    private Boolean inStock;

    public DeliveryInfo(LocalDate deliveryDate, Double deliveryFee, Boolean inStock) {
        this.deliveryDate = deliveryDate;
        this.deliveryFee = deliveryFee;
        this.inStock = inStock;
    }


}
