package com.bookstore.controller.admin.customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;

@WebServlet("/admin/update_customer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));

		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(customerId);

		if (customer != null) {
			String email = request.getParameter("email");
			String fullName = request.getParameter("fullname");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");

			customer.setEmail(email);
			customer.setFullName(fullName);
			customer.setPassword(password);
			customer.setPhone(phoneNumber);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setZipcoce(zipcode);
			customer.setCountry(country);
			customer.setRegisterDate(new Date());

			Customer updateCustomer = customerService.update(customer);
			if (updateCustomer != null) {
				request.getSession().setAttribute("message", "Customer with id " + customerId + " updated succesfully");
				response.sendRedirect("list_customer");
			}else {
				request.getSession().setAttribute("message", "Something Went wrong");
				response.sendRedirect("list_customer");
			}

		} else {
			request.setAttribute("message", "Could not find customer with ID " + customerId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
