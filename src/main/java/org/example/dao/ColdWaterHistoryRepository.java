package org.example.dao;

import org.example.model.ColdWaterHistory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ColdWaterHistoryRepository {

    private EntityManagerFactory entityManagerFactory;

    public ColdWaterHistoryRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(ColdWaterHistory coldWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(coldWaterHistory);

        transaction.commit();
        return true;
    }

    public ColdWaterHistory findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ColdWaterHistory coldWaterHistory = em.find(ColdWaterHistory.class, id);
        return coldWaterHistory;
    }

    public boolean update(ColdWaterHistory coldWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        ColdWaterHistory mergedColdWaterHistory = em.merge(coldWaterHistory);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(ColdWaterHistory coldWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(coldWaterHistory);

        em.getTransaction().commit();
        return true;
    }

    public List<ColdWaterHistory> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<ColdWaterHistory> criteriaQuery = criteriaBuilder.createQuery(ColdWaterHistory.class);
        Root<ColdWaterHistory> coldWaterHistoryRoot = criteriaQuery.from(ColdWaterHistory.class);
        criteriaQuery.select(coldWaterHistoryRoot);
        List<ColdWaterHistory> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }


}

