package com.bookstore.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import com.bookstore.dao.cart.CartDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;

public class CartService {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private CartDao cartDao;

//	public CartService() {
//		this(null,null);
//	}

	public CartService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		if (cartDao == null) {
			cartDao = new CartDao();
		}
	}

	public List<Cart> findByCustomerId(int customerId) {
		return cartDao.findByCustomerId(customerId);
	}

	public Boolean addToCart(Book book) {
		Cart cart = null;
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		cart = cartDao.findByCustomerIdAndBookId(customer.getCustomerId(), book.getBookId());

		if (cart != null) {
			cart.setQuantity(cart.getQuantity() + 1);
			cart.setSubtotal((cart.getSubtotal() + book.getPrice()));
			cartDao.update(cart);
			updatSession();
			return true;
		} else {
			cart = new Cart();
			cart.setBook(book);
			cart.setCustomer(customer);
			cart.setQuantity(1);
			cart.setSubtotal(book.getPrice());
			cartDao.create(cart);
			updatSession();

			return true;
		}
	}

	public boolean updateCart() {
		List<Cart> cartList = null;
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		cartList = findByCustomerId(customer.getCustomerId());

		for (Cart cart : cartList) {
			String bookId = "" + cart.getBook().getBookId();
			int quantity = Integer.parseInt(request.getParameter(bookId));
			if (quantity < 1) {
				cartDao.delete(cart.getCartId());
			} else {
				cart.setQuantity(quantity);
				cart.setSubtotal(quantity * cart.getBook().getPrice());
				Cart update = cartDao.update(cart);
			}
		}
		updatSession();
		return true;
	}

	public boolean clearCart(int customerId) {
		List<Cart> cartList = findByCustomerId(customerId);
		for (Cart cart : cartList) {
			cartDao.delete(cart.getCartId());
		}
		updatSession();
		return true;
	}

	// updating session
	public void updatSession() {
		HttpSession session = request.getSession(false);
		Customer loggedCustomer = (Customer) session.getAttribute("loggedCustomer");
		session.removeAttribute("loggedCustomer");
		if (loggedCustomer != null) {
			CustomerService customerService = new CustomerService();
			loggedCustomer = customerService.getCustomer(loggedCustomer.getCustomerId());
			session.setAttribute("loggedCustomer", loggedCustomer);
		}
	}

}
