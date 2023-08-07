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

@WebServlet("/admin/create_customer")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");

		CustomerService customerService = new CustomerService();
		Customer findByEmail = customerService.findByEmail(email);

		if (findByEmail == null) {
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
				request.getSession().setAttribute("message", "Customer created succesfully");
				response.sendRedirect("list_customer");
			} else {
				request.getSession().setAttribute("message", "Customer not created");
				response.sendRedirect("list_customer");
			}
		}else {
			request.getSession().setAttribute("message","Could not create Customer. Customer with Customer Email " + email + " already exist");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}

	}

}
