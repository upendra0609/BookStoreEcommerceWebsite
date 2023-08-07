package com.bookstore.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
	
		
		UserServices userService = new UserServices();
		
		Users existUser = userService.findByEmail(email);
		
		if(existUser == null) {
			Users user = new Users();
			user.setEmail(email);
			user.setFullName(fullName);
			user.setPassword(password);
			Users createUser = userService.createUser(user);
			
			if(createUser!=null) {
			    request.getSession().setAttribute("message", "User created succesfully");
			    response.sendRedirect("list_users");
			}else {
				request.getSession().setAttribute("message", "Something went wrong");
			    response.sendRedirect("list_users");
			}			
		}else {
			 request.getSession().setAttribute("message", "Could not create user. User with email "+ email +" already exist");
//			 response.sendRedirect("list_users");
//			 showing message in another message.jsp page
			 response.sendRedirect("message.jsp");
		}
	}
}