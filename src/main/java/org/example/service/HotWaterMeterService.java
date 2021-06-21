package org.example.service;

import org.example.dao.HotWaterMeterRepository;
import org.example.model.HotWaterMeter;

import java.util.List;

public class HotWaterMeterService {
    private final HotWaterMeterRepository hotWaterMeterRepository;

    public HotWaterMeterService(HotWaterMeterRepository hotWaterMeterRepository) {
        this.hotWaterMeterRepository = hotWaterMeterRepository;
    }

    public boolean create(HotWaterMeter hotWaterHistory) {
        return hotWaterMeterRepository.create(hotWaterHistory);
    }

    public HotWaterMeter findById(int id){
        return this.hotWaterMeterRepository.findById(id);
    }

    public boolean update(HotWaterMeter hotWaterMeter) {
        if (hotWaterMeter != null) {
            return this.hotWaterMeterRepository.update(hotWaterMeter);
        }
        else {
            return false;
        }
    }

    public boolean delete(HotWaterMeter hotWaterMeter){
        if (hotWaterMeter != null) {
            return this.hotWaterMeterRepository.delete(hotWaterMeter);
        }
        else {
            return false;
        }
    }

    public List<HotWaterMeter> getAll(){
        return hotWaterMeterRepository.getAll();
    }



}
