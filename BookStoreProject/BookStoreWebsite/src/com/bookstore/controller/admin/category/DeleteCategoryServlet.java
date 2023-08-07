package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;

@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));

		CategoryService categoryService = new CategoryService();
		Category category = categoryService.getCategory(categoryId);

		if (category != null) {

			BookService bookService = new BookService();
			long countByCategory = bookService.countByCategory(categoryId);

			if (countByCategory > 0) {
				request.getSession().setAttribute("message","Could not delete category with ID " + categoryId + " because it currently contains some books.");
				response.sendRedirect("list_category");
			} else {
				categoryService.deleteCategory(categoryId);
				request.getSession().setAttribute("message", "Deleted category with ID " + categoryId);
				response.sendRedirect("list_category");
			}
		} else {
			request.setAttribute("message", "Could not find category with ID " + categoryId);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
