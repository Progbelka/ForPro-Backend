package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.Product;

@Stateless
public class Product_rep extends Repository<Product> {
	@PersistenceContext
	private EntityManager entitymanager;

	public Product_rep() {
		super(Product.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entitymanager;
	}
}
