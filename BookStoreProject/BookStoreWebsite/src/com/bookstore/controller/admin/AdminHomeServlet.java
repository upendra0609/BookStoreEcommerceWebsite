package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.Review;
import com.bookstore.service.BookService;
import com.bookstore.service.CustomerService;
import com.bookstore.service.OrderDetailService;
import com.bookstore.service.OrderService;
import com.bookstore.service.ReviewServices;
import com.bookstore.service.UserServices;


@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		OrderService orderService = new OrderService(request, response);
		List<BookOrder> recentSale = orderService.recentSale();
		request.setAttribute("recentSale", recentSale);
		
		long orderCount = orderService.orderCount();
		request.setAttribute("orderCount", orderCount);
		
		ReviewServices reviewServices = new ReviewServices();
		List<Review> recentReview = reviewServices.recentReview();
		request.setAttribute("recentReview", recentReview);
		
		long reviewCount = reviewServices.reviewCount();
		request.setAttribute("reviewCount", reviewCount);
		
		
		UserServices userServices = new UserServices();
		long userCount = userServices.userCount();
		request.setAttribute("userCount", userCount);
		
		BookService bookService = new BookService();
		long bookCount = bookService.bookCount();
		request.setAttribute("bookCount", bookCount);
		
		CustomerService customerService = new CustomerService();
		long customerCount = customerService.customerCount();
		request.setAttribute("customerCount", customerCount);
		
		
		
		String homePage = "index.jsp";
		request.getRequestDispatcher(homePage).forward(request, response);
	}
}