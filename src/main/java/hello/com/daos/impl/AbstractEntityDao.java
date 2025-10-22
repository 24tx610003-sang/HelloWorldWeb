package hello.com.daos.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import hello.com.configs.JPAConfig;

public abstract class AbstractEntityDao<T> {

    private Class<T> entityClass;

    public AbstractEntityDao(Class<T> cls) {
        this.entityClass = cls;
    }

    public void insert(T entity) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }

    public void update(T entity) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }

    public void delete(Object id) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            T entity = enma.find(entityClass, id);
            enma.remove(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }

    public T findById(Object id) {
        EntityManager enma = JPAConfig.getEntityManager();
        T entity = enma.find(entityClass, id);
        enma.close();
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = enma.createQuery(cq);
            return q.getResultList();
        } finally {
            enma.close();
        }
    }

    public Long countAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(entityClass);
            cq.select(enma.getCriteriaBuilder().count(rt));
            Query q = enma.createQuery(cq);
            return (Long) q.getSingleResult();
        } finally {
            enma.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(boolean all, int firstResult, int maxResult) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            CriteriaQuery<Object> cq = enma.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = enma.createQuery(cq);
            if (!all) {
                q.setFirstResult(firstResult);
                q.setMaxResults(maxResult);
            }
            return q.getResultList();
        } finally {
            enma.close();
        }
    }
}
