package org.example.service;
import org.example.dao.ApartmentRepository;
import org.example.model.Apartment;


import java.util.List;

public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public boolean create(Apartment apartment) {
        return apartmentRepository.create(apartment);
    }

    public Apartment findById(int id){
        return this.apartmentRepository.findById(id);
    }

    public boolean update(Apartment apartment) {
        if (apartment != null) {
            return this.apartmentRepository.update(apartment);
        }
        else {
            return false;
        }
    }

    public boolean delete(Apartment apartment){
        if (apartment != null) {
            return this.apartmentRepository.delete(apartment);
        }
        else {
            return false;
        }
    }

    public List<Apartment> getAll(){
        return apartmentRepository.getAll();
    }
}
