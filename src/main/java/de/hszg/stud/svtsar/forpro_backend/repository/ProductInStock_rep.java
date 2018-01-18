package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.ProductInStock;

@Stateless
public class ProductInStock_rep extends Repository<ProductInStock>{

	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductInStock_rep() {
		super(ProductInStock.class);
		
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
