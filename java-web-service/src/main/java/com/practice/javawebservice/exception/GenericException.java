package com.practice.javawebservice.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GenericException {
    private Date timestamp;
    private String message;
    private String details;

    public GenericException(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
