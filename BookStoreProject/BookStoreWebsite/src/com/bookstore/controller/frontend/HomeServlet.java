package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.Review;
import com.bookstore.service.BookService;
import com.bookstore.service.OrderDetailService;
import com.bookstore.service.ReviewServices;


@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	    
	    BookService bookService = new BookService();
	    List<Book> listNewBook = bookService.listNewBook();
	    

	    //setting list new book
	    request.setAttribute("listNewBook", listNewBook);
	    
	    
	    OrderDetailService detailService = new OrderDetailService();
	    List<OrderDetail> mostSellingBook = detailService.mostSellingBook();
		
	    //setting most selling book
	    request.setAttribute("mostSellingBook", mostSellingBook);
	    
	    ReviewServices reviewServices = new ReviewServices();
	    List<Review> mostFavouredBook = reviewServices.mostFavouredBook();
	    
	    request.setAttribute("mostFavouredBook", mostFavouredBook);
	    
		String homePage = "/frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
		dispatcher.forward(request, response);
		
	}
}
