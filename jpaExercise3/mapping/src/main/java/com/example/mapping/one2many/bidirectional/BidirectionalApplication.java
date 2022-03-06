package com.example.mapping.one2many.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BidirectionalApplication {
	public static void main(String[] args) {

		// please delete all the data of both the tables before running
		ApplicationContext applicationContext=SpringApplication.run(BidirectionalApplication.class, args);
		AuthorService as=applicationContext.getBean(AuthorService.class);
		as.createAuthor();
	}
}