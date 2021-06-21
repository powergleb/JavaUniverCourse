package org.example.dao;

import org.example.model.ColdWaterMeter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ColdWaterMeterRepository {
    private EntityManagerFactory entityManagerFactory;

    public ColdWaterMeterRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(ColdWaterMeter coldWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(coldWaterMeter);

        transaction.commit();
        return true;
    }

    public ColdWaterMeter findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ColdWaterMeter coldWaterMeter = em.find(ColdWaterMeter.class, id);
        return coldWaterMeter;
    }

    public boolean update(ColdWaterMeter coldWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        ColdWaterMeter mergedColdWaterMeter = em.merge(coldWaterMeter);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(ColdWaterMeter coldWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(coldWaterMeter);

        em.getTransaction().commit();
        return true;
    }

    public List<ColdWaterMeter> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<ColdWaterMeter> criteriaQuery = criteriaBuilder.createQuery(ColdWaterMeter.class);
        Root<ColdWaterMeter> coldWaterMeterRoot = criteriaQuery.from(ColdWaterMeter.class);
        criteriaQuery.select(coldWaterMeterRoot);
        List<ColdWaterMeter> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }
}


