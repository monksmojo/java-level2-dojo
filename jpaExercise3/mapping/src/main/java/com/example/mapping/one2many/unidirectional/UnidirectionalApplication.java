package com.example.mapping.one2many.unidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UnidirectionalApplication {

	//RUNNING THE SCRIPT RUN FOLOWING COMMANDS IN  DATABASE
	//BEFORE
	//SET foreign_key_checks = 0;
	//drop table author;
	//drop table book;
	//SET foreign_key_checks = 1;
	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(UnidirectionalApplication.class, args);
		AuthorService as=applicationContext.getBean(AuthorService.class);
		as.addAuthor();
	}

}
