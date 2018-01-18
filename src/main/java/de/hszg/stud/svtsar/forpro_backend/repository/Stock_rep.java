package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.Stock;

@Stateless
public class Stock_rep extends Repository<Stock>{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Stock_rep() {
		super(Stock.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
