package de.hszg.stud.svtsar.forpro_backend.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_in_stock database table.
 * 
 */
@Entity
@Table(name="product_in_stock")
@NamedQuery(name="ProductInStock.findAll", query="SELECT p FROM ProductInStock p")
public class ProductInStock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_in_stock_id")
	private int productInStockId;

	@Column(name="amount_available")
	private int amountAvailable;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="stock_id")
	private Stock stock;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductInStock() {
	}

	public int getAmountAvailable() {
		return this.amountAvailable;
	}

	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}