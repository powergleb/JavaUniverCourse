package GasElectricity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class GasMeter {
    @Id
    @GeneratedValue
    @Column(name = "GasMeterId")
    private int GasMeterId;

    @Column(name = "Value")
    private int Value;

    @Column(name = "CostPerOne")
    private int CostPerOne;

    @Column(name = "ApartmentId")
    private int ApartmentId;

    @Column(name = "LastCheckDate")
    private int LastCheckDate;

    public int getGasMeterId() {
        return GasMeterId;
    }

    public void setGasMeterId(int gasMeterId) {
        GasMeterId = gasMeterId;
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
        return "GasMeter{" +
                "GasMeterId=" + GasMeterId +
                ", Value=" + Value +
                ", CostPerOne=" + CostPerOne +
                ", ApartmentId=" + ApartmentId +
                ", LastCheckDate=" + LastCheckDate +
                '}';
    }
}
