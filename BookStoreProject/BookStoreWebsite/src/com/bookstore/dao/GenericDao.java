package com.bookstore.dao;

import java.util.List;

public interface GenericDao<T> {

	public T create(T t);

	public T update(T t);

	public T get(Object id);

	public void delete(Object id);

	public List<T> listAll();

	// Getting all row present in the database
	public long count();

}
