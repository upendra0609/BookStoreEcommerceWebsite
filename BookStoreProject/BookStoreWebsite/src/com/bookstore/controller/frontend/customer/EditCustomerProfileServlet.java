package com.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;


@WebServlet("/edit_customer")
public class EditCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("id"));

		CustomerService customerService = new CustomerService();
		Customer editCustomer = customerService.getCustomer(customerId);


		if (editCustomer != null) {
			request.getSession().setAttribute("editCustomer", editCustomer);
			request.getRequestDispatcher("frontend/edit_profile.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Could not find customer with ID " + customerId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}


	}

}
