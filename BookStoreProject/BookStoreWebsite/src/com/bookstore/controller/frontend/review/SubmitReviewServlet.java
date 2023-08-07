package com.bookstore.controller.frontend.review;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.service.BookService;
import com.bookstore.service.ReviewServices;


@WebServlet("/submit_review")
public class SubmitReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float rating = Float.parseFloat(request.getParameter("rating"));
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 String headline = request.getParameter("headline");
		 String comment = request.getParameter("comment");
		 
		 Customer customer = (Customer)request.getSession().getAttribute("loggedCustomer");
		 
		 BookService bookService = new BookService();
		 Book book = bookService.getBook(bookId);
		 
		 Review review = new Review();
		 review.setBook(book);
		 review.setCustomer(customer);
		 review.setHeadline(headline);
		 review.setComment(comment);
		 review.setRating(rating);
		 review.setReviewTime(new Date());
		 
		 ReviewServices reviewServices = new ReviewServices();
		 Review createReview = reviewServices.createReview(review);
		 
		 if(createReview!=null) {
			 request.setAttribute("book", book);
			 request.setAttribute("reviewMessage", "Your review has been posted. Thank You!");
			 request.getRequestDispatcher("frontend/review_message.jsp").forward(request, response);
		 }
		 
		 
		 
		
	}

}
