package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;


@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId= Integer.parseInt(request.getParameter("id"));
		
		UserServices userService = new UserServices();
		
		if(userId==1) {
			request.setAttribute("message", "The default admin user account cannot be deleted");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			Users getUser = userService.getUser(userId);
			
			if(getUser!=null) {
				userService.deleteUser(userId);
				request.getSession().setAttribute("message", "Deleted user with ID "+userId);
				response.sendRedirect("list_users");
			}else {
				request.setAttribute("message", "Could not find user with ID "+userId);
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
		}
		
	}

}
