package org.example.service;

import org.example.dao.ColdWaterHistoryRepository;
import org.example.model.ColdWaterHistory;

import java.util.List;

public class ColdWaterHistoryService {
    private final ColdWaterHistoryRepository coldWaterHistoryRepository;

    public ColdWaterHistoryService(ColdWaterHistoryRepository coldWaterHistoryRepository) {
        this.coldWaterHistoryRepository = coldWaterHistoryRepository;
    }

    public boolean create(ColdWaterHistory coldWaterHistory) {
        return coldWaterHistoryRepository.create(coldWaterHistory);
    }

    public ColdWaterHistory findById(int id){
        return this.coldWaterHistoryRepository.findById(id);
    }

    public boolean update(ColdWaterHistory coldWaterHistory) {
        if (coldWaterHistory != null) {
            return this.coldWaterHistoryRepository.update(coldWaterHistory);
        }
        else {
            return false;
        }
    }

    public boolean delete(ColdWaterHistory coldWaterHistory){
        if (coldWaterHistory != null) {
            return this.coldWaterHistoryRepository.delete(coldWaterHistory);
        }
        else {
            return false;
        }
    }

    public List<ColdWaterHistory> getAll(){
        return coldWaterHistoryRepository.getAll();
    }
}
