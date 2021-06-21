package org.example.service;

import org.example.dao.PaymentOrderRepository;
import org.example.model.PaymentOrder;

import java.util.List;

public class PaymentOrderService {


    private final PaymentOrderRepository paymentOrderRepository;

    public PaymentOrderService(PaymentOrderRepository paymentOrderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
    }

    public boolean create(PaymentOrder paymentOrder) {
        return paymentOrderRepository.create(paymentOrder);
    }

    public PaymentOrder findById(int id){
        return this.paymentOrderRepository.findById(id);
    }

    public boolean update(PaymentOrder paymentOrder) {
        if (paymentOrder != null) {
            return this.paymentOrderRepository.update(paymentOrder);
        }
        else {
            return false;
        }
    }

    public boolean delete(PaymentOrder paymentOrder){
        if (paymentOrder != null) {
            return this.paymentOrderRepository.delete(paymentOrder);
        }
        else {
            return false;
        }
    }

    public List<PaymentOrder> getAll(){
        return paymentOrderRepository.getAll();
    }

}

