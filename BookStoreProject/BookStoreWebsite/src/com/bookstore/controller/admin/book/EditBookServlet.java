package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;

@WebServlet("/admin/edit_book")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		int bookId = Integer.parseInt(request.getParameter("id"));
		
		
		BookService bookService = new BookService();
		List<Category> categoryList = bookService.getCategory();
		
		

		Book book = bookService.getBook(bookId);
		
		if(book!=null) {
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("book", book);
			request.getRequestDispatcher("book_form.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Could not find book with ID "+bookId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
