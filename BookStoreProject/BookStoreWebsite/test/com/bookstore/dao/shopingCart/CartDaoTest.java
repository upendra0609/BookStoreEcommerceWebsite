package com.bookstore.dao.shopingCart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.dao.cart.CartDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Cart;
import com.bookstore.service.BookService;
import com.bookstore.service.CustomerService;

class CartDaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCreateShopingCart() {
		
		BookService bookService = new BookService();
		Book book = bookService.getBook(16);
		
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(3);
		
		Cart cart = new Cart();
		int quantity = 2;
		cart.setQuantity(quantity);
		cart.setSubtotal(quantity*book.getPrice());
		cart.setBook(book);
		cart.setCustomer(customer);
		
		Cart create = new CartDao().create(cart);
		
		System.out.println(create);
		
		
	}

}
