package org.example.dao;

import org.example.model.Lodger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LodgerRepository {
    private EntityManagerFactory entityManagerFactory;

    public LodgerRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(Lodger lodger) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(lodger);

        transaction.commit();
        return true;
    }

    public Lodger findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Lodger lodger = em.find(Lodger.class, id);
        return lodger;
    }

    public boolean update(Lodger lodger) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Lodger mergedLodger = em.merge(lodger);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(Lodger lodger) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(lodger);

        em.getTransaction().commit();
        return true;
    }

    public List<Lodger> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Lodger> criteriaQuery = criteriaBuilder.createQuery(Lodger.class);
        Root<Lodger> lodgerRoot = criteriaQuery.from(Lodger.class);
        criteriaQuery.select(lodgerRoot);
        List<Lodger> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }
}
