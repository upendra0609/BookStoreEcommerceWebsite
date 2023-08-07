package com.bookstore.dao.category;

import java.io.Serializable;
import java.util.List;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.Category;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object categoryId) {
		return super.find(Category.class, categoryId);
	}

	@Override
	public void delete(Object categoryId) {
	    super.delete(Category.class, categoryId);	
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNameQuery("category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("category.countAll");
	}

	public Category findByCategoryName(String CategoryName) {
		List<Category> findWithNameQuery = super.findWithNameQuery("category.findByCategoryName", "categoryName",
				CategoryName);
		if (findWithNameQuery != null && findWithNameQuery.size() == 1) {
			return findWithNameQuery.get(0);
		}
		return null;
	}

}
