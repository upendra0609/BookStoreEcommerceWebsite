package com.bookstore.controller.frontend.review;

import java.io.IOException;
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

@WebServlet("/write_review")
public class WriteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));

		BookService bookService = new BookService();
		Book book = bookService.getBook(bookId);
		if (book != null) {
			request.setAttribute("book", book);

			Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");

			ReviewServices reviewServices = new ReviewServices();
			Review review = reviewServices.findByCustomerAndBook(customer.getCustomerId(), bookId);

			if (review == null) {
				request.getRequestDispatcher("frontend/review_form.jsp").forward(request, response);
			} else {
				request.setAttribute("review", review);
				request.getRequestDispatcher("frontend/review_form.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Book with ID " + bookId + " not available");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
	}

}
