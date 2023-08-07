package com.bookstore.service;


import java.util.List;

import com.bookstore.dao.review.ReviewDao;
import com.bookstore.entity.Review;

public class ReviewServices {

	private ReviewDao reviewDao;

	public ReviewServices() {
		if (reviewDao == null) {
			this.reviewDao = new ReviewDao();
		}
	}

	public Review updateReview(Review review) {
		return reviewDao.update(review);
	}
	
	public Review createReview(Review review) {
		return reviewDao.create(review);
	}
	
	public void deleteReview(int reviewId) {
		reviewDao.delete(reviewId);
	}
	
	public List<Review> listReview() {
		return reviewDao.listAll();
	}
	
	public Review getReview(int reviewId) {
		return reviewDao.get(reviewId);
	}
	
	public Review findByCustomerAndBook(int customerId, int bookId) {
		return reviewDao.findByCustomerAndBook(customerId, bookId);
	}
	
	
	public List<Review> mostFavouredBook(){
		return reviewDao.mostFavouredBook();
	}
	
	public List<Review> recentReview() {
		return reviewDao.recentReview();
	}
	
	public long reviewCount() {
		return reviewDao.count();
	}

}