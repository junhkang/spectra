package com.example.spectra.controller.api;

import com.example.spectra.dto.MaintenanceDTO;
import com.example.spectra.service.MaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/backup-recovery")
    public MaintenanceDTO getBackupRecovery() {
        return maintenanceService.getBackupRecovery();
    }

    @GetMapping("/schema-changes")
    public MaintenanceDTO getSchemaChanges() {
        return maintenanceService.getSchemaChanges();
    }

}
