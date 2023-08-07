package com.bookstore.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;

@WebServlet("/place_order")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");

		CustomerService customerService = new CustomerService();
		customer = customerService.getCustomer(customer.getCustomerId());

		if (customer == null) {
			request.setAttribute("message", "Invalid Customer");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		} else {
			OrderService orderService = new OrderService(request, response);
			boolean placeOrder = orderService.placeOrder(customer);
			if (placeOrder) {
				request.setAttribute("message", "Thanku You.Your Order has been received.We will deliver your order within few days ");
				request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
			}
		}

	}

}
