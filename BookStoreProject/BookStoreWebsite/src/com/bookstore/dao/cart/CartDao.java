package com.bookstore.dao.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.Cart;

public class CartDao extends JpaDao<Cart> implements GenericDao<Cart> {

	@Override
	public Cart create(Cart shopingCart) {
		return super.create(shopingCart);
	}

	@Override
	public Cart update(Cart shopingCart) {
		return super.update(shopingCart);
	}

	@Override
	public Cart get(Object id) {
		return null;
	}

	@Override
	public void delete(Object id) {
		super.delete(Cart.class, id);
	}

	@Override
	public List<Cart> listAll() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	public List<Cart> findByCustomerId(int customerId) {
		return super.findWithNameQuery("cart.findByCustomerId", "customerId",customerId);
	}
	
	public Cart findByCustomerIdAndBookId(int customerId,int bookId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("customerId", customerId);
		parameter.put("bookId", bookId);
		
		List<Cart> findWithNameQuery = findWithNameQuery("cart.findByCustomerIdAndBookId", parameter);
		
		if(findWithNameQuery.isEmpty()) {
			return null;
		}else {
			return findWithNameQuery.get(0);
		}
	}

}
