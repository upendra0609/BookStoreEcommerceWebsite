package com.bookstore.dao.book;

import java.util.List;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.Book;

public class BookDao  extends JpaDao<Book> implements GenericDao<Book>{

	@Override
	public Book create(Book book) {
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
		
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNameQuery("book.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("book.countAll");
	}
	

	public Book findByTitle(String title) {
		List<Book> findByTitle = super.findWithNameQuery("book.findByBookTitle", "title", title);
		if(findByTitle !=null && findByTitle.size()==1) {
			return findByTitle.get(0);
		}
		return null;
	}
	
	public List<Book> findByCategoryId(int categoryId) {
		return super.findWithNameQuery("book.findBookByCategory", "categoryId", categoryId);
	}
	
	public List<Book> listNewBook(){
		return super.findWithNameQuery("book.listNewBook", 0, 6);
	}
	
	public List<Book> searchBook(String keyword) {
		return super.findWithNameQuery("book.search", "keyword", keyword);
	}
	

}
