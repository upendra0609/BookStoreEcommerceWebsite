package com.bookstore.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;


@WebServlet("/view_profile")
public class ShowCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		    HttpSession session = request.getSession(false);
		

			Customer loggedCustomer = (Customer)session.getAttribute("loggedCustomer");
			session.removeAttribute("loggedCustomer");
			CustomerService customerService= new CustomerService();
			loggedCustomer = customerService.getCustomer(loggedCustomer.getCustomerId());
			session.setAttribute("loggedCustomer", loggedCustomer);
			request.getRequestDispatcher("frontend/customer_profile.jsp").forward(request, response);

	}
}
