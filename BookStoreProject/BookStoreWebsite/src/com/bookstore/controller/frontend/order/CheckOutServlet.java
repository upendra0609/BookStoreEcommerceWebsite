package com.bookstore.controller.frontend.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.service.CartService;


@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
		
		CartService cartService = new CartService(request,response);
		List<Cart> listCart = cartService.findByCustomerId(customer.getCustomerId());
		
		
		request.setAttribute("listCart", listCart);
		request.getRequestDispatcher("frontend/checkout.jsp").forward(request, response);
	}

}
