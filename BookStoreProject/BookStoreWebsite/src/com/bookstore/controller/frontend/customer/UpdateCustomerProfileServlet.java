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


@WebServlet("/update_customer")
public class UpdateCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateCustomerProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(customerId);
		
		
		if(customer!=null) {
			
			
			String fullName = request.getParameter("fullname");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");
			String password = request.getParameter("password");
			
			
			customer.setFullName(fullName);
			customer.setPhone(phoneNumber);
			customer.setAddress(address);
			customer.setCity(city);
			customer.setZipcoce(zipcode);
			customer.setCountry(country);
			customer.setRegisterDate(new Date());
			
			
			
			if(password!="") {
				customer.setPassword(password);
			}
			
			Customer updateCustomer = customerService.update(customer);

			
			if (updateCustomer != null) {
				request.getSession().setAttribute("message", "Customer with id " + customerId + " updated succesfully");
				response.sendRedirect("view_profile");
			}else {
				request.getSession().setAttribute("message", "Something Went wrong");
				response.sendRedirect("view_profile");
			}
			
			
		}else {
			request.setAttribute("message", "Could not find customer with ID " + customerId);
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
	}

}
