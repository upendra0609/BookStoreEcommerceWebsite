package com.bookstore.controller.frontend.book;

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


@WebServlet("/view_category")
public class ViewBookCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		BookService bookService = new BookService();
		
		Category categoryById = bookService.getCategoryById(categoryId);
		
		if(categoryById!=null) {
			List<Book> listBookByCategory = bookService.findByCategoryId(categoryId);
			
			//for heading
			request.setAttribute("category", categoryById);

			//all books in this category
			request.setAttribute("listBookByCategory", listBookByCategory);
			request.getRequestDispatcher("frontend/book_list_by_category.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "Sorry the category with ID "+categoryId+" is not available.");
			request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
		}
		
		
	}

}