package com.bookstore.dao.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.BookOrder;

public class OrderDao extends JpaDao<BookOrder> implements GenericDao<BookOrder> {

	@Override
	public BookOrder create(BookOrder order) {
		return super.create(order);
	}

	@Override
	public BookOrder update(BookOrder order) {
		return super.update(order);
	}

	@Override
	public BookOrder get(Object orderId) {
		return super.find(BookOrder.class, orderId);
	}

	@Override
	public void delete(Object orderId) {
		super.delete(BookOrder.class, orderId);
	}

	@Override
	public List<BookOrder> listAll() {
		return super.findWithNameQuery("bookorder.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("bookorder.countAll");
	}
	
	public long countByCustomerId(int customerId) {
		return super.countWithNamedQuery("bookorder.countByCustomerId","customerId",customerId);
	}
	
	public List<BookOrder> findByCustomerId(int customerId) {
		return super.findWithNameQuery("bookorder.findByCustomerId","customerId",customerId);
	}
	
	public BookOrder findByOrderIdAndCustomerId(int orderId,int customerId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("orderId", orderId);
		param.put("customerId", customerId);
		List<BookOrder> orderList = super.findWithNameQuery("bookorder.findByOrderIdAndCustomerId", param);
		if(!orderList.isEmpty() && orderList.size()==1) {
			return orderList.get(0);
		}else {
			return null;
		}
	}
	
	public List<BookOrder> recentSale(){
		return super.findWithNameQuery("bookorder.findRecentSale", 0, 3);
	}
	

}
