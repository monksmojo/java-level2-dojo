package com.examples.kris.springBootmongo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class BookDTO {
     private String bookName;

     private String author;
}