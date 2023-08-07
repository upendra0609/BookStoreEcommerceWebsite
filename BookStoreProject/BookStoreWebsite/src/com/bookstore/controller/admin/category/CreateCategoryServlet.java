package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;

@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String categoryName = request.getParameter("categoryName");

		CategoryService categoryService = new CategoryService();
		Category findByCategoryName = categoryService.findByCategoryName(categoryName);

		if (findByCategoryName == null) {
			Category category = new Category();
			category.setCategoryName(categoryName);
			Category createCategory = categoryService.createCategory(category);

		    if (createCategory != null) {
				request.getSession().setAttribute("message", "Category created succesfully");
				response.sendRedirect("list_category");
			} else {
				request.getSession().setAttribute("message", "Category not created");
				response.sendRedirect("list_category");
			}
		} else {
			request.getSession().setAttribute("message","Could not create category. Category with Category Name " + categoryName + " already exist");
//			response.sendRedirect("message.jsp");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
