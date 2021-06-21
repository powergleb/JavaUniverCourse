package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "HotWaterMeter")
public class HotWaterMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotWaterMeterId")
    private int hotWaterMeterId;

    @Column(name = "value")
    private int value;

    @Column(name = "costPerOne")
    private int costPerOne;

    @Column(name = "LastCheckDate")
    private int LastCheckDate;

    @JsonManagedReference
    @OneToOne(cascade=CascadeType.ALL)
    private HotWaterHistory hotWaterHistory;

    @JsonBackReference
    @ManyToOne
    private Apartment apartment;

    public int getHotWaterMeterId() {
        return hotWaterMeterId;
    }

    public void setHotWaterMeterId(int hotWaterMeterId) {
        this.hotWaterMeterId = hotWaterMeterId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCostPerOne() {
        return costPerOne;
    }

    public void setCostPerOne(int costPerOne) {
        this.costPerOne = costPerOne;
    }

    public int getLastCheckDate() {
        return LastCheckDate;
    }

    public void setLastCheckDate(int lastCheckDate) {
        LastCheckDate = lastCheckDate;
    }

    public HotWaterHistory getHotWaterHistory() {
        return hotWaterHistory;
    }

    public void setHotWaterHistory(HotWaterHistory hotWaterHistory) {
        this.hotWaterHistory = hotWaterHistory;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "HotWaterMeter{" +
                "hotWaterMeterId=" + hotWaterMeterId +
                ", value=" + value +
                ", costPerOne=" + costPerOne +
                ", LastCheckDate=" + LastCheckDate +
                ", hotWaterHistory=" + hotWaterHistory +
                ", apartment=" + apartment +
                '}';
    }
}
