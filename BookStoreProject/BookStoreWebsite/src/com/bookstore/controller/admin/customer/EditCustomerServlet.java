package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;


@WebServlet("/admin/edit_customer")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("id"));

		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(customerId);


		if (customer != null) {
			request.getSession().setAttribute("customer", customer);
			response.sendRedirect("customer_form.jsp");
		} else {
			request.setAttribute("message", "Could not find customer with ID " + customerId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}


	}

}
