package com.bookstore.dao.review;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.service.CustomerService;

class ReviewDaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException {

		CategoryService categoryService = new CategoryService();
		Category category = categoryService.getCategory(1);


		

		BookService bookService = new BookService();
		Book book = bookService.getBook(15);
		book.setCategory(category);
		
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(10);
		
		
		Review review = new Review();
		review.setHeadline("good");
		review.setComment("ok");
		review.setRating(4.5f);
		review.setReviewTime(new Date());
		review.setBook(book);
		review.setCustomer(customer);

		ReviewDao reviewDao = new ReviewDao();
		Review create = reviewDao.create(review);

		System.out.println(create);

	}

}
