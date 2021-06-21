package org.example.dao;

import org.example.model.Apartment;
import org.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ApartmentRepository {

    private EntityManagerFactory entityManagerFactory;

    public ApartmentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(Apartment apartment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(apartment);

        transaction.commit();
        return true;
    }

    public Apartment findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Apartment apartment = em.find(Apartment.class, id);
        return apartment;
    }

    public boolean update(Apartment apartment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Apartment mergedApartment = em.merge(apartment);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(Apartment apartment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(apartment);

        em.getTransaction().commit();
        return true;
    }

    public List<Apartment> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Apartment> criteriaQuery = criteriaBuilder.createQuery(Apartment.class);
        Root<Apartment> apartmentRoot = criteriaQuery.from(Apartment.class);
        criteriaQuery.select(apartmentRoot);
        List<Apartment> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }


}

