package GasElectricity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ElectricityMeter {
    @Id
    @GeneratedValue
    @Column(name = "ElectricityMeterId")
    private int ElectricityMeterId;

    @Column(name = "Value")
    private int Value;

    @Column(name = "CostPerOne")
    private int CostPerOne;

    @Column(name = "ApartmentId")
    private int ApartmentId;

    @Column(name = "LastCheckDate")
    private int LastCheckDate;

    public int getElectricityMeterId() {
        return ElectricityMeterId;
    }

    public void setElectricityMeterId(int electricityMeterId) {
        ElectricityMeterId = electricityMeterId;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public int getCostPerOne() {
        return CostPerOne;
    }

    public void setCostPerOne(int costPerOne) {
        CostPerOne = costPerOne;
    }

    public int getApartmentId() {
        return ApartmentId;
    }

    public void setApartmentId(int apartmentId) {
        ApartmentId = apartmentId;
    }

    public int getLastCheckDate() {
        return LastCheckDate;
    }

    public void setLastCheckDate(int lastCheckDate) {
        LastCheckDate = lastCheckDate;
    }

    @Override
    public String toString() {
        return "ElectricityMeter{" +
                "ElectricityMeterId=" + ElectricityMeterId +
                ", Value=" + Value +
                ", CostPerOne=" + CostPerOne +
                ", ApartmentId=" + ApartmentId +
                ", LastCheckDate=" + LastCheckDate +
                '}';
    }
}
