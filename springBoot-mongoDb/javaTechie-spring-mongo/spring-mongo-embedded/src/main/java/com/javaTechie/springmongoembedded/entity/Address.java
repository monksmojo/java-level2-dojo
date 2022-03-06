package com.javaTechie.springmongoembedded.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
private String streetAddress;
private String city;
private String state;
private Integer pinCode;

    public Address(String streetAddress, String city, String state, Integer pinCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
}
