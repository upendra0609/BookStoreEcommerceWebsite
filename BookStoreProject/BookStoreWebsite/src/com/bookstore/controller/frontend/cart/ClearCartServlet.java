package com.bookstore.controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CartService;


@WebServlet("/clear_cart")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		
		CartService cartService = new CartService(request, response);
		boolean clearCart = cartService.clearCart(customer.getCustomerId());
		
		if(clearCart) {
			request.getSession().setAttribute("message", "Cart cleared successfully");
			response.sendRedirect("view_cart");
		}
	
	}

}
