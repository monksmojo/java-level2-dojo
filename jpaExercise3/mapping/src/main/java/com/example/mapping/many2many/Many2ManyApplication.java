package com.example.mapping.many2many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Many2ManyApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(Many2ManyApplication.class, args);
		AuthorService as=applicationContext.getBean(AuthorService.class);
		as.insertAuthor();
	}

}
