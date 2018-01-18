package de.hszg.stud.svtsar.forpro_backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class Repository<T> {
	// private EntityManager entityManager;
	private Class<T> entityClass;

	public Repository(Class<T> entityClass) {
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("forpro");
		// this.entityManager = factory.createEntityManager();
		this.entityClass = entityClass;
	}

	abstract public EntityManager getEntityManager();

	public void create(T t) {
		getEntityManager().persist(t);
	}

	public T find(int id) {
		T foundEntity = getEntityManager().find(entityClass, id);

		return foundEntity;
	}

	public List<T> getAll() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);

		criteriaQuery.select(root);
		TypedQuery<T> typedQuery = getEntityManager().createQuery(criteriaQuery);
		List<T> resultList = typedQuery.getResultList();

		return resultList;
	}

	public T update(T t) {
		T updatedEntity = getEntityManager().merge(t);

		return updatedEntity;
	}

	public void delete(T t) {
		getEntityManager().remove(t);
	}
}
