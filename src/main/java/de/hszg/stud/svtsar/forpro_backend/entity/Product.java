package de.hszg.stud.svtsar.forpro_backend.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	private String name;

	private double price;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// bi-directional many-to-one association to ProductInStock
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<ProductInStock> productInStocks;

	// bi-directional many-to-one association to ProductInStore
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<ProductInStore> productInStores;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductInStock> getProductInStocks() {
		return this.productInStocks;
	}

	public void setProductInStocks(List<ProductInStock> productInStocks) {
		this.productInStocks = productInStocks;
	}

	public ProductInStock addProductInStock(ProductInStock productInStock) {
		getProductInStocks().add(productInStock);
		productInStock.setProduct(this);

		return productInStock;
	}

	public ProductInStock removeProductInStock(ProductInStock productInStock) {
		getProductInStocks().remove(productInStock);
		productInStock.setProduct(null);

		return productInStock;
	}

	public List<ProductInStore> getProductInStores() {
		return this.productInStores;
	}

	public void setProductInStores(List<ProductInStore> productInStores) {
		this.productInStores = productInStores;
	}

	public ProductInStore addProductInStore(ProductInStore productInStore) {
		getProductInStores().add(productInStore);
		productInStore.setProduct(this);

		return productInStore;
	}

	public ProductInStore removeProductInStore(ProductInStore productInStore) {
		getProductInStores().remove(productInStore);
		productInStore.setProduct(null);

		return productInStore;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", productInStocks=" + productInStocks + ", productInStores=" + productInStores + "]";
	}

}