package com.bookstore.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.order.OrderDao;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

public class OrderService {
	private OrderDao dao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public OrderService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		if (dao == null) {
			dao = new OrderDao();
		}
	}

	public List<BookOrder> listAll() {
		return dao.listAll();
	}

	public BookOrder findByOrderId(int orderId) {
		return dao.find(BookOrder.class, orderId);
	}
	

	public BookOrder viewOrderDetailForAdmin(int OrderId) {
		BookOrder bookOrder = dao.get(OrderId);
		if (bookOrder != null) {
			return bookOrder;
		} else {
			return null;
		}
	}

	// place order for customer
	public boolean placeOrder(Customer customer) {
		CartService cartService = new CartService(request, response);
		List<Cart> cartList = cartService.findByCustomerId(customer.getCustomerId());

		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");

		String address = streetAddress + "," + city + "," + country + " " + zipcode;

		BookOrder bookOrder = new BookOrder();
		bookOrder.setOrderDateTime(new Date());
		bookOrder.setPaymentMethod(paymentMethod);
		bookOrder.setStatus("order placed");
		bookOrder.setShippingAddress(address);
		bookOrder.setRecipientName(recipientName);
		bookOrder.setRecipientPhone(recipientPhone);
		bookOrder.setCustomer(customer);

		Set<OrderDetail> detailSet = new HashSet<OrderDetail>();
		double orderTotal = 0;
		for (Cart cart : cartList) {
			OrderDetail detail = new OrderDetail();
			detail.setBook(cart.getBook());
			detail.setBookOrder(bookOrder);
			detail.setQuantity(cart.getQuantity());
			detail.setSubtotal(cart.getSubtotal());
			orderTotal += cart.getSubtotal();
			detailSet.add(detail);
		}
		bookOrder.setOrderDetail(detailSet);
		bookOrder.setOrderTotal(orderTotal);

		BookOrder createOrder = dao.create(bookOrder);
		if (createOrder != null) {
			cartService.clearCart(customer.getCustomerId());
			return true;
		} else {
			return false;
		}
	}

	public List<BookOrder> viewOrderForCustomer(int customerId) {
		return dao.findByCustomerId(customerId);
	}

	public BookOrder viewOrderDetailForCustomer(int OrderId, int customerId) {
		BookOrder bookOrder = dao.findByOrderIdAndCustomerId(OrderId, customerId);
		if (bookOrder != null) {
			return bookOrder;
		} else {
			return null;
		}
	}

	public long countByCustomerId(int customerId) {
		return dao.countByCustomerId(customerId);
	}

	public boolean updateOrderByAdmin(BookOrder order) {

		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String shippingAddress = request.getParameter("shippingAddress");
		String paymentMethod = request.getParameter("paymentMethod");
		String orderStatus = request.getParameter("orderStatus");

		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		order.setStatus(orderStatus);

		BookOrder updateOrder = dao.update(order);
		if (updateOrder != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOrderByAdmin(int orderId) {
		dao.delete(orderId);
		return true;
	}

	public boolean cancelOrderByCustomer(BookOrder order) {
		order.setStatus("Cancelled");
		BookOrder updateOrder = dao.update(order);
		if (updateOrder != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<BookOrder> recentSale(){
		return dao.recentSale();
	}
	
	public long orderCount() {
		return dao.count();
	}
}
