package hello.com.daos.impl;

import java.util.List;

import hello.com.configs.JPAConfig;
import hello.com.daos.CategoriesDao;
import hello.com.entity.Categories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CategoriesDaoImpl implements CategoriesDao {

	@Override
	public List<Categories> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<Categories> query = em.createNamedQuery("Categories.findAll", Categories.class);
		List<Categories> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Categories findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		Categories category = em.find(Categories.class, id);
		em.close();
		return category;
	}

	@Override
	public void insert(Categories category) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Categories category) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Categories category = em.find(Categories.class, id);
			if (category != null) {
				em.remove(category);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
