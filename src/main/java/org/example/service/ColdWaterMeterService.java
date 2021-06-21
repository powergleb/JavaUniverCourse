package org.example.service;

import org.example.dao.ColdWaterMeterRepository;
import org.example.model.ColdWaterMeter;

import java.util.List;

public class ColdWaterMeterService {
    private final ColdWaterMeterRepository coldWaterMeterRepository;

    public ColdWaterMeterService(ColdWaterMeterRepository coldWaterMeterRepository) {
        this.coldWaterMeterRepository = coldWaterMeterRepository;
    }

    public boolean create(ColdWaterMeter coldWaterMeter) {
        return coldWaterMeterRepository.create(coldWaterMeter);
    }

    public ColdWaterMeter findById(int id){
        return this.coldWaterMeterRepository.findById(id);
    }

    public boolean update(ColdWaterMeter coldWaterMeter) {
        if (coldWaterMeter != null) {
            return this.coldWaterMeterRepository.update(coldWaterMeter);
        }
        else {
            return false;
        }
    }

    public boolean delete(ColdWaterMeter coldWaterMeter){
        if (coldWaterMeter != null) {
            return this.coldWaterMeterRepository.delete(coldWaterMeter);
        }
        else {
            return false;
        }
    }

    public List<ColdWaterMeter> getAll(){
        return coldWaterMeterRepository.getAll();
    }
}
