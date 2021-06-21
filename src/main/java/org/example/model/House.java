package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "House")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "houseNumber")
    private int houseNumber;

    @Column(name = "street")
    private String street;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "house",  fetch = FetchType.EAGER)
    private List<Apartment> apartments;

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                ", street='" + street + '\'' +
                ", apartments=" + apartments +
                '}';
    }
}
