package com.bookstore.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.service.OrderService;


@WebServlet("/cancel_order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		int orderId = Integer.parseInt(request.getParameter("id"));

		OrderService orderService = new OrderService(request, response);
		BookOrder order = orderService.viewOrderDetailForCustomer(orderId, customer.getCustomerId());
	

		if (order != null) {
			boolean cancelOrderByAdmin = orderService.cancelOrderByCustomer(order);
			if (cancelOrderByAdmin) {
				request.getSession().setAttribute("message", "order with ID " + orderId + " cancelled successfully");
				response.sendRedirect("view_order");
			} else {
				request.getSession().setAttribute("message", "Could not cancel order with " + orderId);
				response.sendRedirect("view_order");
			}
		} else {
			request.setAttribute("message", "Could not found order with " + orderId);
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
	}

}
