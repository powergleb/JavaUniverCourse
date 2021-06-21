package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartmentId")
    private int apartmentId;

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", area=" + area +
                ", credit=" + credit +
                ", house=" + house +
                ", coldWaterMeters=" + coldWaterMeters +
                ", hotWaterMeters=" + hotWaterMeters +
                ", paymentOrders=" + paymentOrders +
                ", lodgers=" + lodgers +
                '}';
    }

    @Column(name = "area")
    private int area;

    @Column(name = "credit")
    private int credit;

    @JsonManagedReference
    @ManyToOne
    private House house;

    @JsonManagedReference
    @OneToMany(mappedBy = "apartment")
    private List<ColdWaterMeter> coldWaterMeters;

    @JsonManagedReference
    @OneToMany(mappedBy = "apartment")
    private List<HotWaterMeter> hotWaterMeters;

    @JsonBackReference
    @OneToMany(mappedBy = "apartment")
    private List<PaymentOrder> paymentOrders;

    @JsonBackReference
    @ManyToMany(mappedBy = "apartments")
    private List<Lodger> lodgers;

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Lodger> getLodgers() {
        return lodgers;
    }

    public void setLodgers(List<Lodger> lodgers) {
        this.lodgers = lodgers;
    }

    public List<ColdWaterMeter> getColdWaterMeters() {
        return coldWaterMeters;
    }

    public void setColdWaterMeters(List<ColdWaterMeter> coldWaterMeters) {
        this.coldWaterMeters = coldWaterMeters;
    }

    public List<HotWaterMeter> getHotWaterMeters() {
        return hotWaterMeters;
    }

    public void setHotWaterMeters(List<HotWaterMeter> hotWaterMeters) {
        this.hotWaterMeters = hotWaterMeters;
    }

    public List<PaymentOrder> getPaymentOrders() {
        return paymentOrders;
    }

    public void setPaymentOrders(List<PaymentOrder> paymentOrders) {
        this.paymentOrders = paymentOrders;
    }

}
