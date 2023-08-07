package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDao<T> {
	private static EntityManagerFactory entityManagerFactory;

	static {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		}
	}

	public JpaDao() {
		super();
	}

	public T create(T entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);

		entityManager.getTransaction().commit();
		entityManager.close();

		return entity;
	}

	public T update(T entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(entity);

		entityManager.getTransaction().commit();
		entityManager.close();

		return entity;
	}

	public T find(Class<T> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		T entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}

		entityManager.close();
		return entity;
	}

	public void delete(Class<T> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		T entity = entityManager.getReference(type, id);

		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<T> findWithNameQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		List<T> result = query.getResultList();

		entityManager.close();

		return result;
	}

	public List<T> findWithNameQuery(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		List<T> result = query.getResultList();

		entityManager.close();

		return result;
	}

	public List<Object[]> findWithNameQueryObject(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		List<Object[]> result = query.getResultList();

		entityManager.close();

		return result;
	}

	public List<T> findWithNameQuery(String queryName, String paramNam, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramNam, paramValue);
		List<T> result = query.getResultList();

		entityManager.close();

		return result;
	}

	public List<T> findWithNameQuery(String queryName, Map<String, Object> parameter) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String, Object>> setParameter = parameter.entrySet();

		for (Entry<String, Object> entry : setParameter) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<T> result = query.getResultList();

		entityManager.close();
		return result;

	}

	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		long result = (long) query.getSingleResult();

		entityManager.close();
		return result;
	}

	public long countWithNamedQuery(String queryName, String paramNam, Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramNam, paramValue);

		long result = (long) query.getSingleResult();
		entityManager.close();
		return result;
	}

	public void close() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

	public void refreshEntity(T entity) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.refresh(entity);
		entityManager.close();
	}
}
