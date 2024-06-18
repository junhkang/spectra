package com.example.spectra.controller.api;

import com.example.spectra.dto.DatabaseConfigDTO;
import com.example.spectra.service.DatabaseConfigService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database-config")
public class DatabaseConfigController {

    private final DatabaseConfigService databaseConfigService;

    public DatabaseConfigController(DatabaseConfigService databaseConfigService) {
        this.databaseConfigService = databaseConfigService;
    }

    @PostMapping("/set-database")
    public String setDatabaseConfig(@RequestBody DatabaseConfigDTO databaseConfigDTO) {
        databaseConfigService.setDatabaseConfig(databaseConfigDTO);
        return "Database configuration set successfully";
    }
}
