package com.bookstore.dao.orderDetail;

import java.util.List;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.OrderDetail;

public class OrderDetailDao extends JpaDao<OrderDetail> implements GenericDao<OrderDetail> {

	@Override
	public OrderDetail create(OrderDetail t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail update(OrderDetail t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetail> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return 0;
	}
	
	public long countByBookId(int bookId) {
		return super.countWithNamedQuery("orderDetail.countByBookId","bookId",bookId);
	}
	
	public List<OrderDetail> mostSellingBook(){
		return super.findWithNameQuery("orderDetail.findMostSellingBook", 0, 6);
	}
	
//	public List<OrderDetail> recentSellingBook(){
//		return super.findWithNameQuery("orderDetail.findRecentSellingBook", 0, 6);
//	}
}
