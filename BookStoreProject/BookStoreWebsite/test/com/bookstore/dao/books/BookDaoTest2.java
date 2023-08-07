package com.bookstore.dao.books;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.book.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDaoTest2 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateBook() throws IOException {
		BookDao bookDao = new BookDao();
		
		Book book = new Book();
		book.setTitle("Java: A Beginner's Guide, Eighth Edition 8th");
		book.setAuthor("Herbert Schildt");
		book.setDescription("Fully updated for Java Platform, Standard Edition 11 (Java SE 11), Java: A Beginner’s Guide, Eighth Edition gets you started programming in Java right away. Best-selling programming author Herb Schildt begins with the basics, such as how to create, compile, and run a Java program. He then moves on to the keywords, syntax, and constructs that form the core of the Java language. The book also covers some of Java’s more advanced features, including multithreaded programming, generics, lambda expressions, modules, and Swing. As an added bonus, an introduction to JShell, Java’s interactive programming tool, is included. Best of all, it’s written in the clear, crisp, uncompromising style that has made Schildt the choice of millions worldwide.");
		book.setIsbn("978-1260440218");
		book.setPrice(500.0f);
		
		
		book.setPublishDate(new Date(12/04/2000));
		book.setLastUpdateTime(new Date(12/02/2023));
		
		String path="C:\\Users\\upendra singh\\Desktop\\Code\\java.jpg";
		byte[] readAllBytes = Files.readAllBytes(Paths.get(path));
		book.setImage(readAllBytes);
		
		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("code");
		
		book.setCategory(category);
		
		bookDao.create(book);
	}

//	@Test
//	public void testUpdateBook() throws IOException, ParseException {
//        BookDao bookDao = new BookDao();
//		
//		Book book = new Book();
//		book.setBookId(3);
//		book.setTitle("Java");
//		book.setAuthor("HH");
//		book.setDescription("Fully updated for Java Platform, Standard Edition 11 (Java SE 11), Java: A Beginner’s Guide, Eighth Edition gets you started programming in Java right away. Best-selling programming author Herb Schildt begins with the basics, such as how to create, compile, and run a Java program. He then moves on to the keywords, syntax, and constructs that form the core of the Java language. The book also covers some of Java’s more advanced features, including multithreaded programming, generics, lambda expressions, modules, and Swing. As an added bonus, an introduction to JShell, Java’s interactive programming tool, is included. Best of all, it’s written in the clear, crisp, uncompromising style that has made Schildt the choice of millions worldwide.");
//		book.setIsbn("978-1260440218");
//		book.setPrice(500.0f);
//		
//	
//		book.setPublishDate(new Date());
//		
//		book.setLastUpdateTime(new Date());
//		
//		String path="C:\\Users\\upendra singh\\Desktop\\Code\\java.jpg";
//		byte[] readAllBytes = Files.readAllBytes(Paths.get(path));
//		book.setImage(readAllBytes);
//		
//		Category category = new Category();
//		category.setCategoryId(1);
//		category.setCategoryName("code");
//		
//		book.setCategory(category);
//		
//		bookDao.update(book);
//	}
	
//	@Test
//	public void testDeleteBook() throws IOException, ParseException {
//        BookDao bookDao = new BookDao();
//		
//		bookDao.delete(3);
//	}
//	
//	@Test
//	public void testGetBook() throws IOException, ParseException {
//        BookDao bookDao = new BookDao();
//		
//		Book book = bookDao.get(10);
//		System.out.println(book.getTitle());
//	}

//	
}
