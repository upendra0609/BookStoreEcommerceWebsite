package com.bookstore.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.service.BookService;

class BookTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGetAvgRating() {
		BookService bookService = new BookService();
		
		Book book = bookService.getBook(14);
		
		float avgRating = book.getAvgRating();
		System.out.println(avgRating);
		
		String ratingString1 = book.getRatingString(2.5f);
		System.out.println(ratingString1);
		
		String ratingString2 = book.getRatingString(1f);
		System.out.println(ratingString2);
		
		String ratingString3 = book.getRatingString(4.8f);
		System.out.println(ratingString3);
	}

}
