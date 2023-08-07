package com.bookstore.controller.frontend.customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;

@WebServlet("/register_customer")
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String message = "";

		String email = request.getParameter("email");

		CustomerService customerService = new CustomerService();
		Customer findByEmail = customerService.findByEmail(email);

		if (findByEmail == null) {

			String fullName = request.getParameter("fullname");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");

			Customer customer = new Customer();
			customer.setEmail(email);
			customer.setFullName(fullName);
			customer.setPassword(password);
			customer.setPhone(phoneNumber);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setZipcoce(zipcode);
			customer.setCountry(country);
			customer.setRegisterDate(new Date());

			Customer createCustomer = customerService.create(customer);

			if (createCustomer != null) {
				message = "you have registered successfully! Thank you.<br>"
						+ "<a href='login'>Click here</a> to login";
			}
		} else {
			message = "Could not register. the email " + email + " is already registered by another customer";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
	}

}
