package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;


@WebServlet("/admin/list_book")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService();
		List<Book> listBook = bookService.listBook();
		
		request.setAttribute("listBooks", listBook);
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}
}
