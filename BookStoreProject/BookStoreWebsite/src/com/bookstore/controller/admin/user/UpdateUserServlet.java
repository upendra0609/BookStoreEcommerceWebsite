package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set at edit servlet
		request.removeAttribute("user");
		
		int userId= Integer.parseInt(request.getParameter("userId"));
		
		UserServices userService = new UserServices();
		Users newUser = userService.getUser(userId);
		
		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		

		Users findByEmail = userService.findByEmail(email);
		
		
		if(newUser != null && (findByEmail==null || newUser.getEmail().equalsIgnoreCase(email))) {
			

			newUser.setEmail(email);
			newUser.setFullName(fullName);
			newUser.setPassword(password);
			Users updateUser = userService.updateUser(newUser);
			
			if(updateUser!=null) {
			    request.getSession().setAttribute("message", "User with id "+ userId+" updated succesfully");
			    response.sendRedirect("list_users");
			}else {
				request.getSession().setAttribute("message", "user not updated");
			    response.sendRedirect("list_users");
			}			
		}else {

			 request.getSession().setAttribute("message", "Could not update user.User with email "+ email +" already exist");
//			 response.sendRedirect("list_users");
//			 showing message in another message.jsp page
			 request.getRequestDispatcher("message.jsp").forward(request, response);
//			 response.sendRedirect("message.jsp");
		}
	}
}
