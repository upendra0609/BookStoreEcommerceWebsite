package com.bookstore.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "review", catalog = "bookstoredb")
@NamedQueries({@NamedQuery(name = "review.listAll", query = "select r from Review r ORDER by r.reviewTime"),
      @NamedQuery(name = "review.countAll", query = "select count(*) from Review r"),
      @NamedQuery(name = "review.countByBookId", query = "select count(*) from Review r where r.book.bookId=:bookId"),
      @NamedQuery(name = "review.countByCustomerId", query = "select count(*) from Review r where r.customer.customerId=:customerId"),
      @NamedQuery(name = "review.findByCustomerAndBook", query = "select r from Review r where r.customer.customerId=:customerId AND r.book.bookId=:bookId"),
      @NamedQuery(name = "review.findMostFavouredBook", query = "select r from Review r group by r.book.bookId having avg(r.rating)>=4"),
   })
public class Review implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer reviewId;
	private String headline;
	private String comment;
	private float rating;
	private Date reviewTime;
	private Customer customer;
	private Book book;

	public Review() {
		super();
	}

	public Review(Integer reviewId, String headline, String comment, float rating, Date reviewTime, Customer customer,
			Book book) {
		super();
		this.reviewId = reviewId;
		this.headline = headline;
		this.comment = comment;
		this.rating = rating;
		this.reviewTime = reviewTime;
		this.customer = customer;
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id", unique = true, nullable = false)
	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@Column(name = "headline",nullable = false, length = 128)
	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "comment", nullable = false, length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "rating", nullable = false)
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "review_time", nullable = false)
	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@Transient
	public String getStarRating() {
		String result = "";
		
		int starCount = (int) this.rating;
		
		for(int i=1; i<=starCount; i++) {
			result += "on,";
		}
		
		int next = starCount + 1;
		
		if(next>this.rating && next-1 != this.rating && !(next>5)) {
			result += "half,";
			next++;
		}
		
		for(int i=next ; i<=5; i++) {
			result += "off,";
		}
		
		return result.substring(0,result.length()-1);
	}
}