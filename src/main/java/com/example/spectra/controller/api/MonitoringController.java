package com.example.spectra.controller.api;

import com.example.spectra.dto.IndexDTO;
import com.example.spectra.dto.MonitoringDTO;
import com.example.spectra.service.MonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/monitoring")
public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/database-status")
    public MonitoringDTO getDatabaseStatus() {
        return monitoringService.getDatabaseStatus();
    }

    @GetMapping("/cpu-memory-usage")
    public MonitoringDTO getCpuMemoryUsage() {
        return monitoringService.getCpuMemoryUsage();
    }

    @GetMapping("/network-io")
    public MonitoringDTO getNetworkIO() {
        return monitoringService.getNetworkIO();
    }

    @GetMapping("/connected-users")
    public MonitoringDTO getConnectedUsers() {
        return monitoringService.getConnectedUsers();
    }

    @GetMapping("/table-locks")
    public MonitoringDTO getTableLocks() {
        return monitoringService.getTableLocks();
    }

    @GetMapping("/index-list")
    public List<MonitoringDTO> getIndexList() {
        return monitoringService.getIndexList();
    }

    @GetMapping("/unused-indexes")
    public List<IndexDTO> getUnusedIndexes(@RequestParam Map<String, Object> map, @RequestParam(defaultValue = "1") int pageNum) {
        return monitoringService.getUnusedIndexes(map, pageNum);
    }

    @GetMapping("/top5-indexes")
    public List<MonitoringDTO> getTop5Indexes() {
        return monitoringService.getTop5Indexes();
    }

    @GetMapping("/active-sessions")
    public MonitoringDTO getActiveSessions() {
        return monitoringService.getActiveSessions();
    }

    @GetMapping("/query-performance")
    public MonitoringDTO getQueryPerformance() {
        return monitoringService.getQueryPerformance();
    }

    @GetMapping("/database-size")
    public MonitoringDTO getDatabaseSize() {
        return monitoringService.getDatabaseSize();
    }
}
