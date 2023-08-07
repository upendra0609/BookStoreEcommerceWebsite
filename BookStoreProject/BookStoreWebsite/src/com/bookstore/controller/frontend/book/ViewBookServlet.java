package com.bookstore.controller.frontend.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;


@WebServlet("/view_book")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId = Integer.parseInt(request.getParameter("id"));
		BookService bookService= new BookService();
		Book book = bookService.getBook(bookId);
		
		if(book!=null) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("frontend/book_detail.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Sorry the book with ID "+bookId+" is not available.");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
		
	}

}
