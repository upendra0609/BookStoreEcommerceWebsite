package com.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.OrderDetailService;


@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId = Integer.parseInt(request.getParameter("id"));
		
		BookService bookService = new BookService();
		Book book = bookService.getBook(bookId);
		
		if(book!=null) {
			OrderDetailService detailService = new OrderDetailService();
			
			if(bookService.countReviewByBookId(bookId)>0) {
				request.setAttribute("message", "Could not delete the book with ID "+bookId+" because it has reviews.");
				request.getRequestDispatcher("list_book").forward(request, response);
			}else if(detailService.countByBookId(bookId)>0) {
				request.setAttribute("message", "Could not delete the book with ID "+bookId+" because there are order associated with it!");
				request.getRequestDispatcher("list_book").forward(request, response);
			}else {
				bookService.deleteBook(bookId);
				request.getSession().setAttribute("message", "Deleted book with ID "+bookId);
				response.sendRedirect("list_book");
			}	
		}else {
			request.setAttribute("message", "Could not find book with ID "+bookId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
