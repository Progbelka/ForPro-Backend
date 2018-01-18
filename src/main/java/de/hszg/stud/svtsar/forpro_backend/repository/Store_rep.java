package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.Store;

@Stateless
public class Store_rep extends Repository<Store> {

	@PersistenceContext
	private EntityManager entityManager;

	public Store_rep() {
		super(Store.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
