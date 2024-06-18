package com.example.spectra.service;

import com.example.spectra.dto.MaintenanceDTO;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    public MaintenanceDTO getBackupRecovery() {
        return new MaintenanceDTO();
    }

    public MaintenanceDTO getSchemaChanges() {
        return new MaintenanceDTO();
    }
}
