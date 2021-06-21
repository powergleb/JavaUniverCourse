package org.example.dao;

import org.example.model.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HouseRepository {
    private EntityManagerFactory entityManagerFactory;

    public HouseRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(House house) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(house);

        transaction.commit();
        return true;
    }

    public House findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        House house = em.find(House.class, id);
        return house;
    }

    public boolean update(House house) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        House mergedHouse = em.merge(house);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(House house) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(house);

        em.getTransaction().commit();
        return true;
    }

    public List<House> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<House> criteriaQuery = criteriaBuilder.createQuery(House.class);
        Root<House> hotWaterHistoryRoot = criteriaQuery.from(House.class);
        criteriaQuery.select(hotWaterHistoryRoot);
        List<House> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }
}

