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

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;

@WebServlet("/admin/update_book")
@MultipartConfig(fileSizeThreshold = 1024 * 10, // 10kb
				 maxFileSize = 1024 * 330, // 300kb
				 maxRequestSize = 1024 * 1024 // 1mb
)
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// removing attribute which was added in edit_book servlet
		request.removeAttribute("categoryList");
		request.removeAttribute("book");

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		

		BookService bookService = new BookService();
		Book newBook = bookService.getBook(bookId);
		
		

		String title = request.getParameter("title");

		Book findByTitle = bookService.findByTitle(title);

		if (newBook != null && (newBook.getTitle().equalsIgnoreCase(title) || findByTitle == null)) {

			int categoryId = Integer.parseInt(request.getParameter("category"));
			//Getting category by categoryId
			Category category = bookService.getCategoryById(categoryId);
			
			
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

			if (part != null && part.getSize() > 0) {
				long size = part.getSize();
				byte[] imageBytes = new byte[(int) size];
				InputStream inputStream = part.getInputStream();
				inputStream.read(imageBytes);
				inputStream.close();

				newBook.setImage(imageBytes);
			}

			newBook.setTitle(title);
			newBook.setAuthor(author);
			newBook.setIsbn(isbn);
			newBook.setPublishDate(publishDate);
			newBook.setPrice(price);
			newBook.setDescription(description);
			newBook.setCategory(category);

			Book updateBook = bookService.update(newBook);

			if (updateBook != null) {
				request.getSession().setAttribute("message", "Book with id " + bookId + " updated succesfully");
				response.sendRedirect("list_book");
			} else {
				request.getSession().setAttribute("message", "book not updated");
				response.sendRedirect("list_book");
			}
		} else {

			request.getSession().setAttribute("message",
					"Could not update book.Book with  name " + bookId + " already exist");
			response.sendRedirect("message.jsp");
		}

	}

}
