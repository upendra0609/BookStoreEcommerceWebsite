package com.bookstore.controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CartService;

@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartService cartService = new CartService(request, response);
		boolean updateCart = cartService.updateCart();
		
		if(updateCart) {
//			request.getSession().setAttribute("message", "item updated successfully");
			response.sendRedirect("view_cart");
		}
		
	}

}
