package org.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PaymentOrder")
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentOrderId",nullable = true)
    private int paymentOrderId;

    @Column(name = "hotWaterPayment")
    private int hotWaterPayment;

    @Column(name = "coldWaterPayment")
    private int coldWaterPayment;

    @Column(name = "areaPayment")
    private int areaPayment;

    @Column(name = "total")
    private int total;

    @JsonManagedReference
    @ManyToOne
    private Apartment apartment;

    public int getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(int paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public int getHotWaterPayment() {
        return hotWaterPayment;
    }

    public void setHotWaterPayment(int hotWaterPayment) {
        this.hotWaterPayment = hotWaterPayment;
    }

    public int getColdWaterPayment() {
        return coldWaterPayment;
    }

    public void setColdWaterPayment(int coldWaterPayment) {
        this.coldWaterPayment = coldWaterPayment;
    }

    public int getAreaPayment() {
        return areaPayment;
    }

    public void setAreaPayment(int areaPayment) {
        this.areaPayment = areaPayment;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "PaymentOrder{" +
                "paymentOrderId=" + paymentOrderId +
                ", hotWaterPayment=" + hotWaterPayment +
                ", coldWaterPayment=" + coldWaterPayment +
                ", areaPayment=" + areaPayment +
                ", total=" + total +
                ", apartment=" + apartment +
                '}';
    }
}
