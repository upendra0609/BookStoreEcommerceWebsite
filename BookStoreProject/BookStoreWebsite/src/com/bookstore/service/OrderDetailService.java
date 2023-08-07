package com.bookstore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.orderDetail.OrderDetailDao;
import com.bookstore.entity.OrderDetail;

public class OrderDetailService {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderDetailDao dao;
	
	
	
	
	public OrderDetailService() {
		super();
		if(dao==null) {
			dao = new OrderDetailDao();
		}
	}


	public long countByBookId(int bookId) {
		return dao.countByBookId(bookId);
	}
	
	public List<OrderDetail> mostSellingBook(){
		return dao.mostSellingBook();
	}
	
//	public List<OrderDetail> recentSellingBook(){
//		return dao.recentSellingBook();
//	}
}
