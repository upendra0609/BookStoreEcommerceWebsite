package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.customer.CustomerDao;
import com.bookstore.dao.review.ReviewDao;
import com.bookstore.entity.Customer;

public class CustomerService {

	private CustomerDao customerDao;
	private ReviewDao reviewDao;

	public CustomerService() {
		if (customerDao == null) {
			this.customerDao = new CustomerDao();
		}
		if (reviewDao == null) {
			this.reviewDao = new ReviewDao();
		}
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer getCustomer(int customerId) {
		return customerDao.get(customerId);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(int customerId) {
		customerDao.delete(customerId);
	}

	public List<Customer> listCustomer() {
		return customerDao.listAll();
	}

	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	public Customer checkLogin(String email, String password) {
		return customerDao.checkLogin(email, password);
	}

	//checking whether customer has review any book or not
	public long countReviewByCustomerId(int customerId) {
		return reviewDao.countReviewByCustomerId( customerId);
	}
	
	public long customerCount() {
		return customerDao.count();
	}
}
