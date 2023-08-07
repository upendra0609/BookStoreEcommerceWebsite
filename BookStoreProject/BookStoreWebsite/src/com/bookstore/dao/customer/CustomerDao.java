package com.bookstore.dao.customer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.Customer;

public class CustomerDao extends JpaDao<Customer> implements GenericDao<Customer>, Serializable {


	private static final long serialVersionUID = 1L;

	@Override
	public Customer create(Customer customer) {
		return super.create(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return super.update(customer);
	}

	@Override
	public Customer get(Object customerId) {
		return super.find(Customer.class, customerId);
	}

	@Override
	public void delete(Object customerId) {
		super.delete(Customer.class, customerId);
	}

	@Override
	public List<Customer> listAll() {
		return super.findWithNameQuery("customer.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("customer.countAll");
	}
	
	public Customer findByEmail(String email) {
		List<Customer> findWithNameQuery = super.findWithNameQuery("customer.findByEmail","email",email);
		if(findWithNameQuery !=null && findWithNameQuery.size()==1) {
			return findWithNameQuery.get(0);
		}return null;
	}
	
	public Customer checkLogin(String email, String password) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("email", email);
		parameter.put("password", password);
		List<Customer> listCustomer = super.findWithNameQuery("customer.checkLogin", parameter);
		
		if(listCustomer.size()==1) {
			return listCustomer.get(0);
		}
		return null;
	}
	
		

}
