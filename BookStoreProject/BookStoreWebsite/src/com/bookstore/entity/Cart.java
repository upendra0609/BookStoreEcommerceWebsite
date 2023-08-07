package com.bookstore.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "cart", catalog = "bookstoredb")
@NamedQueries({@NamedQuery(name = "cart.findByCustomerId", query = "select c from Cart c WHERE c.customer.customerId =:customerId"),
	           @NamedQuery(name = "cart.findByCustomerIdAndBookId", query = "select c from Cart c WHERE c.customer.customerId =:customerId AND c.book.bookId=:bookId"),
               @NamedQuery(name = "cart.findByCustomerIdAndBook", query = "select c from Cart c WHERE c.customer.customerId =:customerId AND c.book.bookId=:bookId")
})
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cartId;
	private int quantity;
	private double subtotal;
	private Customer customer;
	private Book book;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopingCart_id", unique = true, nullable = false)
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Column(name = "quantity", nullable = false, length = 64)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "subtotal", nullable = false, length = 64)
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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
	


}
