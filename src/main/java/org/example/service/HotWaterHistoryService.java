package org.example.service;

import org.example.dao.HotWaterHistoryRepository;
import org.example.model.HotWaterHistory;

import java.util.List;

public class HotWaterHistoryService {
    private final HotWaterHistoryRepository hotWaterHistoryRepository;

    public HotWaterHistoryService(HotWaterHistoryRepository hotWaterHistoryRepository) {
        this.hotWaterHistoryRepository = hotWaterHistoryRepository;
    }

    public boolean create(HotWaterHistory hotWaterHistory) {
        return hotWaterHistoryRepository.create(hotWaterHistory);
    }

    public HotWaterHistory findById(int id){
        return this.hotWaterHistoryRepository.findById(id);
    }

    public boolean update(HotWaterHistory coldWaterHistory) {
        if (coldWaterHistory != null) {
            return this.hotWaterHistoryRepository.update(coldWaterHistory);
        }
        else {
            return false;
        }
    }

    public boolean delete(HotWaterHistory hotWaterHistory){
        if (hotWaterHistory != null) {
            return this.hotWaterHistoryRepository.delete(hotWaterHistory);
        }
        else {
            return false;
        }
    }

    public List<HotWaterHistory> getAll(){
        return hotWaterHistoryRepository.getAll();
    }
}
