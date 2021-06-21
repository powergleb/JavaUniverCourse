package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "ColdWaterHistory")
public class ColdWaterHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coldWaterHistoryId")
    private int coldWaterHistoryId;

    @OneToOne(mappedBy = "coldWaterHistory", fetch = FetchType.EAGER)
    private ColdWaterMeter coldWaterMeter;

    @Column(name = "lastMonthValue")
    private int lastMonthValue;

    @Column(name = "newMonthValue")
    private int newMonthValue;

    @Column(name = "lastMonthDate")
    private int lastMonthDate;

    @Column(name = "newMonthDate")
    private int newMonthDate;

    public int getColdWaterHistoryId() {
        return coldWaterHistoryId;
    }

    public void setColdWaterHistoryId(int coldWaterHistoryId) {
        this.coldWaterHistoryId = coldWaterHistoryId;
    }

    public ColdWaterMeter getColdWaterMeter() {
        return coldWaterMeter;
    }

    public void setColdWaterMeter(ColdWaterMeter coldWaterMeter) {
        this.coldWaterMeter = coldWaterMeter;
    }

    public int getLastMonthValue() {
        return lastMonthValue;
    }

    public void setLastMonthValue(int lastMonthValue) {
        this.lastMonthValue = lastMonthValue;
    }

    public int getNewMonthValue() {
        return newMonthValue;
    }

    public void setNewMonthValue(int newMonthValue) {
        this.newMonthValue = newMonthValue;
    }

    public int getLastMonthDate() {
        return lastMonthDate;
    }

    public void setLastMonthDate(int lastMonthDate) {
        this.lastMonthDate = lastMonthDate;
    }

    public int getNewMonthDate() {
        return newMonthDate;
    }

    public void setNewMonthDate(int newMonthDate) {
        this.newMonthDate = newMonthDate;
    }

    @Override
    public String toString() {
        return "ColdWaterHistory{" +
                "coldWaterHistoryId=" + coldWaterHistoryId +
                ", coldWaterMeter=" + coldWaterMeter +
                ", lastMonthValue=" + lastMonthValue +
                ", newMonthValue=" + newMonthValue +
                ", lastMonthDate=" + lastMonthDate +
                ", newMonthDate=" + newMonthDate +
                '}';
    }
}
