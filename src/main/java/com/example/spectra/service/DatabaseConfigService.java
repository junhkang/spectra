package com.example.spectra.service;

import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.dto.DatabaseConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConfigService {

    @Autowired
    private DynamicDataSourceConfig dynamicDataSourceConfig;

    public void setDatabaseConfig(DatabaseConfigDTO databaseConfigDTO) {
//        dynamicDataSourceConfig.setDynamicDataSource(
//                databaseConfigDTO.getUrl(),
//                databaseConfigDTO.getUsername(),
//                databaseConfigDTO.getPassword(),
//                databaseConfigDTO.getDriverClassName(),
//                databaseConfigDTO.getNamespace()
//        );
    }
}
