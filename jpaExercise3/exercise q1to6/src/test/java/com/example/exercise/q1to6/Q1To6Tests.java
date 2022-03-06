package com.example.exercise.q1to6;

import com.example.exercise.q1to6.entity.Address;
import com.example.exercise.q1to6.entity.Author;
import com.example.exercise.q1to6.entity.Book;
import com.example.exercise.q1to6.entity.Subjects;
import com.example.exercise.q1to6.repository.Author1to6Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Q1To6Tests {
	@Autowired
	Author1to6Repository author1To6Repository;



	@Test
	void contextLoads() {
	}

	// Q1 to 4
	@Test // creating a new author with address as embedded object
	// Persist 3 subjects for each author.
	void testCreateAuthor1(){

		Author author=new Author();
		author.setAuthorName("mason");
		author.setAuthorAge(45);

		// embedding address
		Address address=new Address();
		address.setStreetNumber("565");
		address.setState("york shire");
		address.setLocation("hobbiton");

		author.setAddress(address);


		Subjects sub1=new Subjects();
		sub1.setSubId(1);
		sub1.setSubjectName("friction");

		Subjects sub2=new Subjects();
		sub2.setSubId(2);
		sub2.setSubjectName("non-friction");

		Subjects sub3=new Subjects();
		sub3.setSubId(3);
		sub3.setSubjectName("thriller");

		// adding subject to the list
		author.addSubject(sub1);
		author.addSubject(sub2);
		author.addSubject(sub3);

		// adding book to author
		//adding book to the author
		Book b1=new Book();
		b1.setbId(12);
		b1.setBookName("rd sharma");
		b1.setPublisherName("sharma publications");
		author.addBook(b1);

		author1To6Repository.save(author);
	}

	@Test
	void testCreateAuthor2(){

		Author author=new Author();
		author.setAuthorName("clark kent");
		author.setAuthorAge(56);

		// embedding address
		Address address=new Address();
		address.setStreetNumber("b99");
		address.setState("delhi");
		address.setLocation("shastri nagar");

		author.setAddress(address);

		Subjects sub1=new Subjects();
		sub1.setSubId(7);
		sub1.setSubjectName("maths");

		Subjects sub2=new Subjects();
		sub2.setSubId(8);
		sub2.setSubjectName("accounts");

		Subjects sub3=new Subjects();
		sub3.setSubId(9);
		sub3.setSubjectName("advance maths");

		// adding subject to the list
		author.addSubject(sub1);
		author.addSubject(sub2);
		author.addSubject(sub3);

		//adding book to the author
		Book b1=new Book();
		b1.setbId(11);
		b1.setBookName("u-like");
		b1.setPublisherName("saraha");
		author.addBook(b1);

		author1To6Repository.save(author);
	}

}
