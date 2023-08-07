package com.bookstore.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "customer", catalog = "bookstoredb")
@NamedQueries({ @NamedQuery(name = "customer.findAll", query = "select c from Customer c ORDER by c.customerId"),
		@NamedQuery(name = "customer.findByCustomerId", query = "select c from Customer c WHERE c.customerId =:customerId"),
		@NamedQuery(name = "customer.findByEmail", query = "select c from Customer c WHERE c.email =:email"),
		@NamedQuery(name = "customer.countAll", query = "select count(*) from Customer c"),
		@NamedQuery(name = "customer.listNewCustomer", query = "select c from Customer c ORDER by c.registerDate DESC"),
		@NamedQuery(name = "customer.checkLogin", query = "select c from Customer c WHERE c.email =:email AND c.password =:password"), })
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer customerId;
	private String email;
	private String fullName;
	private String address;
	private String city;
	private String country;
	private String phone;
	private String zipcoce;
	private String password;
	private Date registerDate;
	private Set<Review> reviewSet = new HashSet<Review>();
	private Set<BookOrder> bookOrderSet = new HashSet<BookOrder>();
	private Set<Cart> cartSet = new HashSet<Cart>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", unique = true, nullable = false)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "email", unique = true, nullable = false, length = 64)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 15)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false, length = 30)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "address", nullable = false, length = 128)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 32)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", nullable = false, length = 64)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone", nullable = false, length = 15)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", nullable = false)
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "zipcode", nullable = false, length = 24)
	public String getZipcoce() {
		return zipcoce;
	}

	public void setZipcoce(String zipcoce) {
		this.zipcoce = zipcoce;
	}

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	public Set<Review> getReviewSet() {
		return reviewSet;
	}

	public void setReviewSet(Set<Review> reviewSet) {
		this.reviewSet = reviewSet;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<BookOrder> getBookOrderSet() {
		return bookOrderSet;
	}

	public void setBookOrderSet(Set<BookOrder> bookOrderSet) {
		this.bookOrderSet = bookOrderSet;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<Cart> getCartSet() {
		return cartSet;
	}

	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}

	@Transient
	public double getCartTotal() {
		double cartTotal = 0;
		
		if(cartSet.isEmpty()) {
			return 0;
		}else {
			for (Cart cart : this.cartSet) {
				cartTotal += cart.getSubtotal();
			}
			return cartTotal;
		}
		
	}

	@Transient
	public int getCartQuantity() {
		int quantity = 0;
		if(cartSet.isEmpty()) {
			return 0;
		}else {
			for (Cart cart : this.cartSet) {
				quantity += cart.getQuantity();
			}
			return quantity;
		}
		
	}

}