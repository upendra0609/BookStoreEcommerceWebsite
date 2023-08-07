package com.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;


@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		CustomerService customerService = new CustomerService();
		Customer checkLogin = customerService.checkLogin(email, password);
		
		if (checkLogin !=null) {
			request.getSession().setAttribute("loggedCustomer", checkLogin);
			response.sendRedirect("./");
		} else {
			request.getSession().setAttribute("message", "login failed");
			request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
		}
	}

}
