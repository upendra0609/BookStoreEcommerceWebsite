package com.bookstore.controller.frontend.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.service.OrderService;

@WebServlet("/view_order")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
		
		
		OrderService orderService = new OrderService(request,response);
		List<BookOrder> orderList = orderService.viewOrderForCustomer(customer.getCustomerId());
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("frontend/order_list.jsp").forward(request, response);;
		
		
	}

}
