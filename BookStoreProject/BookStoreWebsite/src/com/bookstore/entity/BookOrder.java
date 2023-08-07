package com.bookstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "bookorder", catalog = "bookstoredb")
@NamedQueries({ @NamedQuery(name = "bookorder.findAll", query = "select o from BookOrder o ORDER by o.orderId"),
	            @NamedQuery(name = "bookorder.findByOrderIdAndCustomerId", query = "select o from BookOrder o where o.orderId =:orderId AND o.customer.customerId=:customerId"),
	            @NamedQuery(name = "bookorder.findByCustomerId", query = "select o from BookOrder o where o.customer.customerId =:customerId ORDER by o.orderDateTime DESC"),
	            @NamedQuery(name = "bookorder.countByCustomerId", query = "select count(*) from BookOrder o where o.customer.customerId=:customerId"),
	            @NamedQuery(name = "bookorder.findRecentSale", query = "select o from BookOrder o ORDER by o.orderDateTime DESC"),
	            @NamedQuery(name = "bookorder.countAll", query = "select count(*) from BookOrder o"),
	})
public class BookOrder implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer orderId;
	private Date orderDateTime;
	private String paymentMethod;
	private double orderTotal;
	private String status;
	private String shippingAddress;
	private String recipientName;
	private String recipientPhone;
	private Customer customer;
	Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_Time", nullable = false)
	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@Column(name = "payment_method", nullable = false, length = 20)
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "orderTotal", nullable = false)
	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "shipping_address", nullable = false, length = 256)
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "recepient_name", nullable = false, length = 30)
	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	@Column(name = "recepient_phone", nullable = false, length = 15)
	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bookOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<OrderDetail> getOrderDetail() {
		return orderDetailSet;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	@Transient
	public long getTotalQuantity() {
		long quantity = 0;
		for(OrderDetail order: orderDetailSet) {
			quantity += order.getQuantity();
		}
		return quantity;
	}
	

}