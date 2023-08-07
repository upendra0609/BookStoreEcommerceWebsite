package com.bookstore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderService;

@WebServlet("/admin/delete_customer")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int customerId = Integer.parseInt(request.getParameter("id"));

		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(customerId);
		
		OrderService orderService = new OrderService(request, response);


		if (customer != null) {
			if(customerService.countReviewByCustomerId(customerId)>0) {
				request.setAttribute("message", "Could not delete customer with ID " + customerId+" because he/she posted reviews for books");
				request.getRequestDispatcher("list_customer").forward(request, response);
			}else if(orderService.countByCustomerId(customerId)>0) {
				request.setAttribute("message", "Could not delete customer with ID " + customerId+" because there are order associated with it!");
				request.getRequestDispatcher("list_customer").forward(request, response);
			}else {
				customerService.delete(customerId);
				request.getSession().setAttribute("message", "Deleted customer with ID " + customerId);
				response.sendRedirect("list_customer");
			}
		} else {
			request.setAttribute("message", "Could not find customer with ID " + customerId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}

	}
}
