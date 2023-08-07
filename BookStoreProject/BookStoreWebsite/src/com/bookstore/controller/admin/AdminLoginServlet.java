package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.UserServices;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserServices userService = new UserServices();
		boolean checkLogin = userService.checkLogin(email, password);

		if (checkLogin) {
			request.getSession().setAttribute("email", email);
			response.sendRedirect("./");
		} else {
			request.getSession().setAttribute("message", "login failed");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
	}
}
