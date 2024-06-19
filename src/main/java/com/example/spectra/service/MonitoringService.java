package com.example.spectra.service;

import com.example.spectra.dto.IndexDTO;
import com.example.spectra.dto.MonitoringDTO;
import com.example.spectra.repository.dynamic.MonitoringRepository;
import com.example.spectra.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MonitoringService {
    private final MonitoringRepository monitoringRepository;

    public MonitoringService(MonitoringRepository monitoringRepository) {
        this.monitoringRepository = monitoringRepository;
    }

    public MonitoringDTO getDatabaseStatus() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getCpuMemoryUsage() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getNetworkIO() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getConnectedUsers() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getTableLocks() {
        return new MonitoringDTO();
    }

    public List<MonitoringDTO> getIndexList() {
        return List.of(new MonitoringDTO());
    }

    public List<IndexDTO> getUnusedIndexes(Map<String, Object> map, int pageNum) {
        map.put("limit", Constants.PAGE_SIZE);
        map.put("offset", (pageNum - 1) * Constants.PAGE_SIZE);
        return monitoringRepository.getUnusedIndexes(map);
    }

    public List<IndexDTO> getAllIndexes(Map<String, Object> map, int pageNum) {
        map.put("limit", Constants.PAGE_SIZE);
        map.put("offset", (pageNum - 1) * Constants.PAGE_SIZE);
        return monitoringRepository.getAllIndexes(map);
    }

    public List<MonitoringDTO> getTop5Indexes() {
        return List.of(new MonitoringDTO());
    }

    public MonitoringDTO getActiveSessions() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getQueryPerformance() {
        return new MonitoringDTO();
    }

    public MonitoringDTO getDatabaseSize() {
        return new MonitoringDTO();
    }
}
