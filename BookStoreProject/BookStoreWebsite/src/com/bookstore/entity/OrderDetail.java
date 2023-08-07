package com.bookstore.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail", catalog = "bookstoredb")
@NamedQueries({ @NamedQuery(name = "orderDetail.findByBookId", query = "select o from OrderDetail o where o.book.bookId=:bookId"),
	@NamedQuery(name = "orderDetail.countByBookId", query = "select count(*) from OrderDetail o where o.book.bookId=:bookId"),
	@NamedQuery(name = "orderDetail.findMostSellingBook", query = "select o from OrderDetail o group by o.book.bookId ORDER by quantity DESC"),
})
public class OrderDetail implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

//	composite id key
	
	private OrderDetailId primaryKey = new OrderDetailId();
	private int quantity;
	private double subtotal;
	private Book book;
	private BookOrder bookOrder;

	public OrderDetail() {
	}	
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="primaryKey.bookOrder", column = @Column(name="order_id", nullable = false)),
		@AttributeOverride(name="primaryKey.book", column = @Column(name="book_id", nullable = false)),		
	})
	public OrderDetailId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(OrderDetailId primaryKey) {
		this.primaryKey = primaryKey;
	}
	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Column(name = "subtotal", nullable = false, precision = 12, scale = 0)
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", insertable = false, updatable = false, nullable = false)
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
		this.primaryKey.setBook(book);
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
		this.primaryKey.setBookOrder(bookOrder);
	}
		
}
