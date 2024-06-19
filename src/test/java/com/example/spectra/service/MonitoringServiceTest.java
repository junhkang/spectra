package com.example.spectra.service;

import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.dto.IndexDTO;
import com.example.spectra.repository.dynamic.MonitoringRepository;
import com.example.spectra.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@SpringBootTest
public class MonitoringServiceTest {
    @Autowired
    private ApplicationContext applicationContext;
    private MonitoringService monitoringService;
    @Autowired
    private MonitoringRepository monitoringRepository;

    @BeforeEach
    public void setUp() throws Exception {
        DynamicDataSourceConfig dynamicDataSourceConfig = new DynamicDataSourceConfig(applicationContext);
        DynamicDatabaseService dynamicDatabaseService = new DynamicDatabaseService(dynamicDataSourceConfig);
        monitoringService = new MonitoringService(monitoringRepository);

        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";
        String driverClassName = "";
        String namespace = "";
        dynamicDatabaseService.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
    }

    @Test
    @DisplayName("미사용 인덱스 리스트 정상 조회")
    public void shouldSelectUnusedIndexList() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<IndexDTO> unusedIndexList = monitoringService.getUnusedIndexes(map, 1);
        assertEquals(unusedIndexList.size(), Constants.PAGE_SIZE);
    }

    @Test
    @DisplayName("모든 인덱스 리스트 조회")
    public void shouldSelectAllIndexList() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<IndexDTO> allIndexesList = monitoringService.getAllIndexes(map, 1);
        assertEquals(allIndexesList.size(), Constants.PAGE_SIZE);
    }
}
