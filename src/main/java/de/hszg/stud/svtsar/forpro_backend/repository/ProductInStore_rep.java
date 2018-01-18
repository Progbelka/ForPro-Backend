package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.ProductInStore;

@Stateless
public class ProductInStore_rep extends Repository<ProductInStore>{

	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductInStore_rep() {
		super(ProductInStore.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
