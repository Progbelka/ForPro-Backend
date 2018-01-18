package de.hszg.stud.svtsar.forpro_backend.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_in_store database table.
 * 
 */
@Entity
@Table(name="product_in_store")
@NamedQuery(name="ProductInStore.findAll", query="SELECT p FROM ProductInStore p")
public class ProductInStore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_in_store_id")
	private int productInStoreId;

	@Column(name="amount_available")
	private int amountAvailable;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	public ProductInStore() {
	}

	public int getAmountAvailable() {
		return this.amountAvailable;
	}

	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}