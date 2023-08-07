package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.category.CategoryDao;
import com.bookstore.entity.Category;

public class CategoryService {

	private CategoryDao categoryDao;

	public CategoryService() {
		if (categoryDao == null) {
			this.categoryDao = new CategoryDao();
		}
	}

	public Category getCategory(int categoryId) {
		return categoryDao.get(categoryId);
	}

	public Category createCategory(Category category) {
		return categoryDao.create(category);
	}

	public Category updateCategory(Category category) {
		return categoryDao.update(category);
	}

	public void deleteCategory(int categoryId) {
		categoryDao.delete(categoryId);
	}
	

	public List<Category> listCategory() {
		return categoryDao.listAll();
	}

	public Category findByCategoryName(String categoryName) {
		return categoryDao.findByCategoryName(categoryName);
	}

}
