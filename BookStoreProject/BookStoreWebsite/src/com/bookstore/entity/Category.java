package com.bookstore.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category", catalog = "bookstoredb")
@NamedQueries({ @NamedQuery(name = "category.findAll", query = "select c from Category c ORDER by c.categoryName"),
	           @NamedQuery(name = "category.findByCategoryName", query = "select c from Category c WHERE c.categoryName =:categoryName"),
	           @NamedQuery(name = "category.countAll", query = "select count(*) from Category c")
	          })
public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer categoryId;
	private String categoryName;
	private Set<Book> bookSet = new HashSet<Book>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", unique = true, nullable = false, length = 30)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
		

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}