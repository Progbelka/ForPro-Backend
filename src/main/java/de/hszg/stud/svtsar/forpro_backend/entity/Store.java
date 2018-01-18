package de.hszg.stud.svtsar.forpro_backend.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;

	private String address;

	private String city;

	private String country;

	//bi-directional many-to-one association to ProductInStore
	@OneToMany(mappedBy="store", fetch=FetchType.EAGER)
	private List<ProductInStore> productInStores;

	public Store() {
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<ProductInStore> getProductInStores() {
		return this.productInStores;
	}

	public void setProductInStores(List<ProductInStore> productInStores) {
		this.productInStores = productInStores;
	}

	public ProductInStore addProductInStore(ProductInStore productInStore) {
		getProductInStores().add(productInStore);
		productInStore.setStore(this);

		return productInStore;
	}

	public ProductInStore removeProductInStore(ProductInStore productInStore) {
		getProductInStores().remove(productInStore);
		productInStore.setStore(null);

		return productInStore;
	}

}