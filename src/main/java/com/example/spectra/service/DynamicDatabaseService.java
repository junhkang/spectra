package com.example.spectra.service;

import com.example.spectra.config.database.DatabaseConfig;
import com.example.spectra.config.database.DynamicDataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicDatabaseService {

    private final DynamicDataSourceConfig dynamicDataSourceConfig;

    @Autowired
    public DynamicDatabaseService(DynamicDataSourceConfig dynamicDataSourceConfig) {
        this.dynamicDataSourceConfig = dynamicDataSourceConfig;
    }

    public void setDynamicDataSource(String dbUrl, String dbUsername, String dbPassword, String driverClassName, String namespace) throws Exception {
        dynamicDataSourceConfig.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
        DynamicDataSourceConfig.setNamespace("com.example.spectra.mapper." + namespace);
    }


}
