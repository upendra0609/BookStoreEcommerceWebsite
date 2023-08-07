package com.bookstore.controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.CartService;


@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		BookService bookService = new BookService();
		Book book = bookService.getBook(bookId);
		
		if(book==null) {
			request.setAttribute("message", "Book is not added to cart.Book with Id "+bookId+" does not exist");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}else {
			CartService cartService = new CartService(request,response);
			Boolean addToCart = cartService.addToCart(book);
			if(addToCart) {
				request.getSession().setAttribute("message", "item added into cart");
				response.sendRedirect("view_cart");
			}
		}
			
	}

}
