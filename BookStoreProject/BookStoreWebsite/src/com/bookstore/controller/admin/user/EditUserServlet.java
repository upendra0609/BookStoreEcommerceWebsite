package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId= Integer.parseInt(request.getParameter("id"));
		
		UserServices userService = new UserServices();
		Users getUser = userService.getUser(userId);
		
		
		if(getUser!=null) {
			request.setAttribute("user", getUser);
			request.getRequestDispatcher("user_form.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Could not find user with ID "+userId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}
}