package de.hszg.stud.svtsar.forpro_backend.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int сategoryId;

	private String name;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category category;

	// bi-directional many-to-one association to Category
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Category> categories;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

	public Category() {
	}

	public int getСategoryId() {
		return this.сategoryId;
	}

	public void setСategoryId(int сategoryId) {
		this.сategoryId = сategoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setCategory(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setCategory(null);

		return category;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	@Override
	public String toString() {
		return "Category [сategoryId=" + сategoryId + ", name=" + name + ", category=" + category + ", categories="
				+ categories + ", products=" + products + "]";
	}

}