package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ColdWaterMeter")
public class ColdWaterMeter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coldWaterMeterId")
    private int coldWaterMeterId;

    @Column(name = "value")
    private int value;

    @Column(name = "costPerOne")
    private int costPerOne;

    @Column(name = "apartmentId")
    private int apartmentId;

    @JsonManagedReference
    @OneToOne(cascade=CascadeType.ALL)
    private ColdWaterHistory coldWaterHistory;

    @JsonBackReference
    @ManyToOne
    private Apartment apartment;



    @Column(name = "lastCheckDate")
    private int lastCheckDate;

    public int getColdWaterMeterId() {
        return coldWaterMeterId;
    }

    public void setColdWaterMeterId(int coldWaterMeterId) {
        this.coldWaterMeterId = coldWaterMeterId;
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

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public ColdWaterHistory getColdWaterHistory() {
        return coldWaterHistory;
    }

    public void setColdWaterHistory(ColdWaterHistory coldWaterHistory) {
        this.coldWaterHistory = coldWaterHistory;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(int lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    @Override
    public String toString() {
        return "ColdWaterMeter{" +
                "coldWaterMeterId=" + coldWaterMeterId +
                ", value=" + value +
                ", costPerOne=" + costPerOne +
                ", apartmentId=" + apartmentId +
                ", coldWaterHistory=" + coldWaterHistory +
                ", apartment=" + apartment +
                ", lastCheckDate=" + lastCheckDate +
                '}';
    }
}


