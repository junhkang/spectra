package com.example.spectra.service;


import com.example.spectra.config.database.DatabaseConfig;
import com.example.spectra.config.database.DynamicDataSourceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class DynamicDatabaseServiceTest {

    @InjectMocks
    private DynamicDatabaseService dynamicDatabaseService;

    @Mock
    private DynamicDataSourceConfig dynamicDataSourceConfig;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("동적 데이터 소스를 성공적으로 바인딩")
    public void shouldSetDynamicDataSourceSuccessfully() throws Exception {
        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";
        String driverClassName = "";
        String namespace = "";

        doNothing().when(dynamicDataSourceConfig).setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);

        dynamicDatabaseService.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);

        verify(dynamicDataSourceConfig).setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
        assertEquals(namespace, DatabaseConfig.getNamespace());
    }

    @Test
    @DisplayName("잘못된 데이터베이스 주소의 경우 적절한 예외처리")
    public void shouldThrowExceptionForInvalidDatabaseUrl() {
        String invalidDbUrl = "invalid_url";
        String dbUsername = "user";
        String dbPassword = "password";
        String driverClassName = "org.postgresql.Driver";
        String namespace = "com.example.spectra.mapper";

        Exception exception = assertThrows(Exception.class, () -> {
            dynamicDatabaseService.setDynamicDataSource(invalidDbUrl, dbUsername, dbPassword, driverClassName, namespace);
        });

        assertEquals("Invalid database URL", exception.getMessage());
    }
}