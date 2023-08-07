package com.bookstore.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.BookOrder;
import com.bookstore.service.OrderService;

@WebServlet("/admin/list_order")
public class ListOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderService orderService = new OrderService(request,response);
		List<BookOrder> orderList = orderService.listAll();
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("order_list.jsp").forward(request, response);;
		
	}

}
