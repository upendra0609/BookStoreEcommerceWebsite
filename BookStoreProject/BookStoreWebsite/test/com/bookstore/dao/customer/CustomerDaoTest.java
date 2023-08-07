package com.bookstore.dao.customer;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Customer;

class CustomerDaoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("aaa@gmail");
		customer.setFullName("aaa");
		customer.setPassword("aa");
		customer.setPhone("1234");
		customer.setAddress("satna");
		customer.setCity("satna");
		customer.setZipcoce("1234");
		customer.setCountry("india");
		
		CustomerDao customerDao = new CustomerDao();
		customerDao.create(customer);
	}

}
