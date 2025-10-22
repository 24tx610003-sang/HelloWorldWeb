package hello.com.daos.impl;

import java.util.List;

import hello.com.configs.JPAConfig;
import hello.com.daos.UserJPADao;
import hello.com.entity.UserJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserJPADaoImpl implements UserJPADao {

    @Override
    public UserJPA findByUsername(String username) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<UserJPA> query = em.createQuery("SELECT u FROM UserJPA u WHERE u.username = :username", UserJPA.class);
            query.setParameter("username", username);
            List<UserJPA> list = query.getResultList();
            return list.isEmpty() ? null : list.get(0);
        } finally {
            em.close();
        }
    }

    @Override
    public List<UserJPA> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<UserJPA> query = em.createQuery("SELECT u FROM UserJPA u", UserJPA.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void insert(UserJPA user) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(UserJPA user) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            UserJPA user = em.find(UserJPA.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
