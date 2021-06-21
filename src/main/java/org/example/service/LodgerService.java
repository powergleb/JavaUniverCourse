package org.example.service;

import org.example.dao.LodgerRepository;
import org.example.model.Lodger;

import java.util.List;

public class LodgerService {

    private final LodgerRepository lodgerRepository;

    public LodgerService(LodgerRepository lodgerRepository) {
        this.lodgerRepository = lodgerRepository;
    }

    public boolean create(Lodger lodger) {
        return lodgerRepository.create(lodger);
    }

    public Lodger findById(int id){
        return this.lodgerRepository.findById(id);
    }

    public boolean update(Lodger lodger) {
        if (lodger != null) {
            return this.lodgerRepository.update(lodger);
        }
        else {
            return false;
        }
    }

    public boolean delete(Lodger lodger){
        if (lodger != null) {
            return this.lodgerRepository.delete(lodger);
        }
        else {
            return false;
        }
    }

    public List<Lodger> getAll(){
        return lodgerRepository.getAll();
    }
}
