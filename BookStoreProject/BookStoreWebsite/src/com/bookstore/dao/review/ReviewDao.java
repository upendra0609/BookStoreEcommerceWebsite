package com.bookstore.dao.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.dao.GenericDao;
import com.bookstore.dao.JpaDao;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.Review;

public class ReviewDao extends JpaDao<Review> implements GenericDao<Review> {

	@Override
	public Review create(Review review) {
		return super.create(review);
	}

	@Override
	public Review update(Review review) {
		return super.update(review);
	}

	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);

	}

	@Override
	public void delete(Object id) {
		super.delete(Review.class, id);

	}

	@Override
	public List<Review> listAll() {
		return super.findWithNameQuery("review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("review.countAll");
	}

	public long countReviewByCustomerId(int customerId) {
		return super.countWithNamedQuery("review.countByCustomerId", "customerId", customerId);
	}

	public long countReviewByBookId(int bookId) {
		return super.countWithNamedQuery("review.countByBookId", "bookId", bookId);
	}

	public Review findByCustomerAndBook(int customerId, int bookId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("customerId", customerId);
		parameter.put("bookId", bookId);
		List<Review> findWithNameQuery = super.findWithNameQuery("review.findByCustomerAndBook", parameter);

		if (!findWithNameQuery.isEmpty() && findWithNameQuery.size() == 1) {
			return findWithNameQuery.get(0);
		}
		return null;
	}

	public List<Review> mostFavouredBook() {
		return super.findWithNameQuery("review.findMostFavouredBook", 0, 6);
	}

	public List<Review> recentReview() {
		return super.findWithNameQuery("review.listAll", 0, 3);
	}
}
