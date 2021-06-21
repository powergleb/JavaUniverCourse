package org.example.dao;

import org.example.model.PaymentOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PaymentOrderRepository {
    private EntityManagerFactory entityManagerFactory;

    public PaymentOrderRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(PaymentOrder paymentOrder) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(paymentOrder);

        transaction.commit();
        return true;
    }

    public PaymentOrder findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        PaymentOrder paymentOrder = em.find(PaymentOrder.class, id);
        return paymentOrder;
    }

    public boolean update(PaymentOrder paymentOrder) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        PaymentOrder mergedPaymentOrder = em.merge(paymentOrder);

        em.getTransaction().commit();
        return true;
    }

    public boolean delete(PaymentOrder paymentOrder) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.remove(paymentOrder);

        em.getTransaction().commit();
        return true;
    }

    public List<PaymentOrder> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<PaymentOrder> criteriaQuery = criteriaBuilder.createQuery(PaymentOrder.class);
        Root<PaymentOrder> paymentOrderRoot = criteriaQuery.from(PaymentOrder.class);
        criteriaQuery.select(paymentOrderRoot);
        List<PaymentOrder> resultList1 = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        return resultList1;
    }
}

