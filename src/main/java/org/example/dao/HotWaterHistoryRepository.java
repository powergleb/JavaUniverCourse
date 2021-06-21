package org.example.dao;

import org.example.model.HotWaterHistory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class HotWaterHistoryRepository {
    private EntityManagerFactory entityManagerFactory;

    public HotWaterHistoryRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(HotWaterHistory hotWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(hotWaterHistory);

        transaction.commit();
        return true;
    }

    public HotWaterHistory findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        HotWaterHistory hotWaterHistory = em.find(HotWaterHistory.class, id);
        return hotWaterHistory;
    }

    public boolean update(HotWaterHistory hotWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        HotWaterHistory mergedHotWaterHistory = em.merge(hotWaterHistory);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(HotWaterHistory hotWaterHistory) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(hotWaterHistory);

        em.getTransaction().commit();
        return true;
    }

    public List<HotWaterHistory> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<HotWaterHistory> criteriaQuery = criteriaBuilder.createQuery(HotWaterHistory.class);
        Root<HotWaterHistory> hotWaterHistoryRoot = criteriaQuery.from(HotWaterHistory.class);
        criteriaQuery.select(hotWaterHistoryRoot);
        List<HotWaterHistory> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }

}
