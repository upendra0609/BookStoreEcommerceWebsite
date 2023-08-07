package com.bookstore.dao.order;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.service.CartService;
import com.bookstore.service.CustomerService;

class OrderDaoTest {
	
	HttpServletRequest request;
	HttpServletResponse response;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testCreateBookOrder() {
		
		Customer customer = new CustomerService().getCustomer(11);
		
		BookOrder bookOrder = new BookOrder();
		
		bookOrder.setOrderDateTime(new Date());
		bookOrder.setPaymentMethod("cash on delivery");
		bookOrder.setRecipientName("BBB");
		bookOrder.setRecipientPhone("11111");
		bookOrder.setShippingAddress("bhopal");
		bookOrder.setStatus("processing");
		
		bookOrder.setCustomer(customer);
		
		
		
		Set<OrderDetail> set = new HashSet<OrderDetail>();
		
		CartService cartService = new CartService(request,response);
		List<Cart> cartList = cartService.findByCustomerId(customer.getCustomerId());
		
		
		double total = 0;
		for(Cart c: cartList) {
			OrderDetail orderDetail1 = new OrderDetail();
			orderDetail1.setBook(c.getBook());
			orderDetail1.setQuantity(c.getQuantity());
			orderDetail1.setSubtotal(c.getSubtotal());
			orderDetail1.setBookOrder(bookOrder);
			total += c.getSubtotal();
			set.add(orderDetail1);
		}
		
		System.out.println(set.size());
		
		bookOrder.setOrderDetail(set);
		bookOrder.setOrderTotal(total);
		
		OrderDao dao = new OrderDao();
		dao.create(bookOrder);
	}


}
