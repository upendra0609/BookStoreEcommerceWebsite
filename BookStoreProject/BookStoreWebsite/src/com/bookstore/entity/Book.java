package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "book", catalog = "bookstoredb")
@NamedQueries({ @NamedQuery(name = "book.findAll", query = "select b from Book b ORDER by b.title"),
		@NamedQuery(name = "book.findByBookTitle", query = "select b from Book b WHERE b.title =:title"),
		@NamedQuery(name = "book.countAll", query = "select count(*) from Book b"),
		@NamedQuery(name = "book.countByCategory", query = "select count(b) from Book b where b.category.categoryId =:categoryId"),
		@NamedQuery(name = "book.findBookByCategory", query = "select b from Book b where b.category.categoryId=:categoryId"),
		@NamedQuery(name = "book.listNewBook", query = "select b from Book b ORDER by b.publishDate DESC"),
		@NamedQuery(name = "book.search", query = "select b from Book b where b.title LIKE '%' || :keyword || '%' OR b.author LIKE '%' || :keyword || '%' OR b.description LIKE '%' || :keyword || '%' OR b.category.categoryName LIKE '%' || :keyword || '%'"), })
public class Book implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bookId;
	private String title;
	private String author;
	private String description;
	private String isbn;
	private byte[] image;
	private float price;
	private Date publishDate = new Date();
	private Date lastUpdateTime = new Date();
	private Category category;
	private Set<Review> reviewSet = new HashSet<Review>();
	private Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();
	private Set<Cart> shopingCartSet = new HashSet<Cart>();

	public Book() {
		super();
	}

	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(Integer bookId, String title, String author, String description, String isbn, byte[] image, float price,
			Date publishDate, Date lastUpdateTime, Category category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		this.category = category;
	}

	public Book(Integer bookId, String title, String author, String description, String isbn, byte[] image, float price,
			Date publishDate, Date lastUpdateTime, Category category, Set<Review> reviewSet) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		this.category = category;
		this.reviewSet = reviewSet;
	}

	public Book(Integer bookId, String title, String author, String description, String isbn, byte[] image, float price,
			Date publishDate, Date lastUpdateTime, Category category, Set<Review> reviewSet,
			Set<OrderDetail> orderDetailSet) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		this.category = category;
		this.reviewSet = reviewSet;
		this.orderDetailSet = orderDetailSet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "title", unique = true, nullable = false, length = 128)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "auther", length = 64, nullable = false)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "description", length = 2000, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "isbn", length = 15, nullable = false)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

//	@Lob
	@Column(name = "image", nullable = false, columnDefinition = "MEDIUMBLOB")
//	@Type(type = "org.hibernate.type.BinaryType")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price", nullable = false)
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publish_date", nullable = false)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_upadte_time", nullable = false)
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
	public Set<Review> getReviewSet() {
		return reviewSet;
	}

	public void setReviewSet(Set<Review> reviewSet) {
		this.reviewSet = reviewSet;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	@Transient
	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(this.image);
	}

	public void setBase64Image(String base64Image) {
//		this.base64Image = base64Image;
	}

	@Transient
	public float getAvgRating() {
		float sum = 0;

		if (this.reviewSet.isEmpty()) {
			return 0;
		} else {
			for (Review review : reviewSet) {
				sum += review.getRating();
			}
		}
		return sum / reviewSet.size();
	}

	@Transient
	public String getRatingString(float avgRating) {
		String result = "";

		int numberOfStar = (int) avgRating;

		for (int i = 1; i <= numberOfStar; i++) {
			result += "on,";
		}

		int next = numberOfStar + 1;

		if (next > avgRating && (next - 1) != avgRating && !(next > 5)) {
			result += "half,";
			next++;
		}


		for (int i = next; i <= 5; i++) {
			result += "off,";
		}

		return result.substring(0, result.length() - 1);
	}

	@Transient
	public String getStarRating() {
		return getRatingString(getAvgRating());
	}

	@Transient
	public int getReviewCount() {
		return reviewSet.size();
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
	public Set<Cart> getShopingCartSet() {
		return shopingCartSet;
	}

	public void setShopingCartSet(Set<Cart> shopingCartSet) {
		this.shopingCartSet = shopingCartSet;
	}

}