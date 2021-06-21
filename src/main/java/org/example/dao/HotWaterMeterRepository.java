package org.example.dao;

import org.example.model.HotWaterMeter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HotWaterMeterRepository {
    private EntityManagerFactory entityManagerFactory;

    public HotWaterMeterRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(HotWaterMeter hotWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(hotWaterMeter);

        transaction.commit();
        return true;
    }

    public HotWaterMeter findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        HotWaterMeter hotWaterMeter = em.find(HotWaterMeter.class, id);
        return hotWaterMeter;
    }

    public boolean update(HotWaterMeter hotWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        HotWaterMeter mergedHotWaterMeter = em.merge(hotWaterMeter);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(HotWaterMeter hotWaterMeter) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(hotWaterMeter);

        em.getTransaction().commit();
        return true;
    }

    public List<HotWaterMeter> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<HotWaterMeter> criteriaQuery = criteriaBuilder.createQuery(HotWaterMeter.class);
        Root<HotWaterMeter> hotWaterMeterRoot = criteriaQuery.from(HotWaterMeter.class);
        criteriaQuery.select(hotWaterMeterRoot);
        List<HotWaterMeter> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }
}


