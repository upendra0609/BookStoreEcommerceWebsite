package com.bookstore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;


@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//removing attribute which was added in edit_category servlet
		request.removeAttribute("category");
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		
		CategoryService categoryService = new CategoryService();
		Category newCategory = categoryService.getCategory(categoryId);
		
		
		String categoryName = request.getParameter("categoryName");
		Category findByCategoryName = categoryService.findByCategoryName(categoryName);
		
		
		if(newCategory!=null && (newCategory.getCategoryName().equalsIgnoreCase(categoryName) || findByCategoryName==null)) {
			newCategory.setCategoryName(categoryName);
			Category updateCategory = categoryService.updateCategory(newCategory);
			
			if(updateCategory!=null) {
			    request.getSession().setAttribute("message", "Category with id "+ categoryId+" updated succesfully");
			    response.sendRedirect("list_category");
			}else {
				request.getSession().setAttribute("message", "category not updated");
			    response.sendRedirect("list_category");
			}			
		}else {

			 request.getSession().setAttribute("message", "Could not update category.Category with  name "+ categoryId +" already exist");
			 response.sendRedirect("message.jsp");
		}
		
	}

}
