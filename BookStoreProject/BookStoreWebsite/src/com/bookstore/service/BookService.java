package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.book.BookDao;
import com.bookstore.dao.category.CategoryDao;
import com.bookstore.dao.review.ReviewDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookService {
	private BookDao bookDao;
	private CategoryDao categoryDao;
	private ReviewDao reviewDao;

	public BookService() {
		if (bookDao == null) {
			this.bookDao = new BookDao();
		}

		if (categoryDao == null) {
			this.categoryDao = new CategoryDao();
		}
		if (reviewDao == null) {
			this.reviewDao = new ReviewDao();
		}
	}

	public List<Book> listBook() {
		return bookDao.listAll();
	}

	public List<Category> getCategory() {
		return categoryDao.listAll();
	}

	public Category getCategoryById(int categoryId) {
		return categoryDao.get(categoryId);
	}

	public Book create(Book newBook) {
		return bookDao.create(newBook);
	}

	public Book update(Book newBook) {
		return bookDao.update(newBook);
	}

	public Book findByTitle(String bookTitle) {
		return bookDao.findByTitle(bookTitle);
	}

	public Book getBook(int bookId) {
		return bookDao.get(bookId);
	}

	public void deleteBook(int bookId) {
		bookDao.delete(bookId);
	}

	public List<Book> findByCategoryId(int categoryId) {
		return bookDao.findByCategoryId(categoryId);
	}

	public List<Book> listNewBook() {
		return bookDao.listNewBook();
	}

	public List<Book> searchBook(String keyword) {
		return bookDao.searchBook(keyword);
	}

	public long countByCategory(int categoryId) {
		List<Book> findByCategoryId = bookDao.findByCategoryId(categoryId);
		return findByCategoryId.size();
	}

	// checking whether book is having review or not
	public long countReviewByBookId(int bookId) {
		return reviewDao.countReviewByBookId(bookId);
	}
	
	public long bookCount() {
		return bookDao.count();
	}

}
