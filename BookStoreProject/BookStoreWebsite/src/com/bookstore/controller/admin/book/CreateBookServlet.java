package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.entity.Category;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;


@WebServlet("/admin/create_book")
@MultipartConfig(
		   fileSizeThreshold = 1024 * 10,  //10kb
		   maxFileSize = 1024 * 330,       //300kb 
		   maxRequestSize = 1024 * 1024    //1mb
		)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService categoryService = new CategoryService();
		BookService bookService = new BookService();
		
		
		
		int categoryId = Integer.parseInt(request.getParameter("category"));
	
		Category category = categoryService.getCategory(categoryId);
		
				
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Part part = request.getPart("image");
		
		Book findByTitle = bookService.findByTitle(title);
		if(findByTitle == null) {
			Book newBook = new Book();
			
			newBook.setTitle(title);
			newBook.setAuthor(author);
			newBook.setIsbn(isbn);
			newBook.setPublishDate(publishDate);
			newBook.setPrice(price);
			newBook.setDescription(description);
			newBook.setCategory(category);
			
			if(part !=null && part.getSize()>0) {
				long size = part.getSize();
				byte[] imageBytes = new byte[(int)size];
				InputStream inputStream = part.getInputStream();
				inputStream.read(imageBytes);
				inputStream.close();
				
				newBook.setImage(imageBytes);
			}
			
			Book createBook = bookService.create(newBook);
			
			if(createBook !=null) {
				request.getSession().setAttribute("message", "Book created succesfully");
				response.sendRedirect("list_book");
			}else {
				request.getSession().setAttribute("message", "Book not created");
				response.sendRedirect("list_book");
			}
		}else {
			request.getSession().setAttribute("message","Could not create Book. Book with Book Title " + title + " already exist");
			request.getRequestDispatcher("message.jsp").forward(request, response);;
		}
		
		
		
	}

}
