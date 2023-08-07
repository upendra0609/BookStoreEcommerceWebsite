package com.bookstore.controller.frontend.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String keyword = request.getParameter("keyboard");

		BookService bookService = new BookService();

		List<Book> listBook = null;

		if (keyword.equals("")) {
			listBook = bookService.listBook();
		} else {
			listBook = bookService.searchBook(keyword);
		}

		request.setAttribute("keyword", keyword);
		request.setAttribute("listBook", listBook);
		request.getRequestDispatcher("/frontend/search_result.jsp").forward(request, response);

	}

}
