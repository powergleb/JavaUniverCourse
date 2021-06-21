package org.example.service;

import org.example.dao.HouseRepository;
import org.example.model.House;

import java.util.List;

public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public boolean create(House house) {
        return houseRepository.create(house);
    }

    public House findById(int id){
        return this.houseRepository.findById(id);
    }

    public boolean update(House house) {
        if (house != null) {
            return this.houseRepository.update(house);
        }
        else {
            return false;
        }
    }

    public boolean delete(House house){
        if (house != null) {
            return this.houseRepository.delete(house);
        }
        else {
            return false;
        }
    }

    public List<House> getAll(){
        return houseRepository.getAll();
    }
}
