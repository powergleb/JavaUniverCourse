package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Lodger")
public class Lodger extends User {
    @JsonManagedReference
    @ManyToMany
    private List<Apartment> apartments;

    @Column(name = "FullName")
    private String FullName;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String toString() {
        return "Lodger{" +
                "apartments=" + apartments +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
