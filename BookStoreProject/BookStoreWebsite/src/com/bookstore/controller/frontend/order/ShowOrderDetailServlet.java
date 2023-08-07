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


@WebServlet("/show_order_detail")
public class ShowOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		
		
		OrderService orderService = new OrderService(request, response);
		BookOrder order = orderService.viewOrderDetailForCustomer(orderId,customer.getCustomerId());
		
		if(order!=null) {
			request.setAttribute("order", order);
			request.getRequestDispatcher("frontend/order_detail.jsp").forward(request, response);
		}if(order==null) {
			request.setAttribute("message","Could not find order with ID "+orderId+"!");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
		
		
	}

}
