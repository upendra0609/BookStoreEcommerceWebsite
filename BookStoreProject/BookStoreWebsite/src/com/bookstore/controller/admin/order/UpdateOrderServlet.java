package com.bookstore.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.BookOrder;
import com.bookstore.service.OrderService;

@WebServlet("/admin/update_order")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));

		OrderService orderService = new OrderService(request, response);
		BookOrder order = orderService.findByOrderId(orderId);

		if (order != null) {
			boolean updateOrderByAdmin = orderService.updateOrderByAdmin(order);
			if (updateOrderByAdmin) {
				request.getSession().setAttribute("message", "order with ID " + orderId + " updated successfully");
				response.sendRedirect("list_order");
			} else {
				request.getSession().setAttribute("message", "Could not update order with " + orderId);
				response.sendRedirect("list_order");
			}
		} else {
			request.setAttribute("message", "Could not found order with " + orderId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
