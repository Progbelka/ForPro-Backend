package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hszg.stud.svtsar.forpro_backend.entity.Category;

@Stateless
public class Category_rep extends Repository<Category> {
	@PersistenceContext
	private EntityManager entityManager;

	public Category_rep() {
		super(Category.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
