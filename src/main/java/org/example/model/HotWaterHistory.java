package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "HotWaterHistory")
public class HotWaterHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotWaterHistoryId")
    private int hotWaterHistoryId;

    @OneToOne(mappedBy = "hotWaterHistory", fetch = FetchType.EAGER)
    private HotWaterMeter hotWaterMeter;

    @Column(name = "lastMonthValue")
    private int lastMonthValue;

    @Column(name = "newMonthValue")
    private int newMonthValue;

    @Column(name = "lastMonthDate")
    private int lastMonthDate;

    @Column(name = "newMonthDate")
    private int newMonthDate;

    public int getHotWaterHistoryId() {
        return hotWaterHistoryId;
    }

    public void setHotWaterHistoryId(int hotWaterHistoryId) {
        this.hotWaterHistoryId = hotWaterHistoryId;
    }

    public HotWaterMeter getHotWaterMeter() {
        return hotWaterMeter;
    }

    public void setHotWaterMeter(HotWaterMeter hotWaterMeter) {
        this.hotWaterMeter = hotWaterMeter;
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
        return "HotWaterHistory{" +
                "hotWaterHistoryId=" + hotWaterHistoryId +
                ", hotWaterMeter=" + hotWaterMeter +
                ", lastMonthValue=" + lastMonthValue +
                ", newMonthValue=" + newMonthValue +
                ", lastMonthDate=" + lastMonthDate +
                ", newMonthDate=" + newMonthDate +
                '}';
    }
}
