package com.example.spectra.service;


import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.repository.dynamic.IndexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
//@MybatisTest
public class DynamicDatabaseServiceTest {

    @Autowired
    private DynamicDatabaseService dynamicDatabaseService;
    @InjectMocks
    private IndexRepository indexRepository;

    @Autowired
    private DynamicDataSourceConfig dynamicDataSourceConfig;

    @Autowired
    private IndexRepository indexRepository;

    @BeforeEach
    public void setUp() throws Exception {
        String dbUrl = "";
        String dbUsername = "";
        String dbPassword = "";
        String driverClassName = "";
        String namespace = "";
        dynamicDatabaseService.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
    }

    @Test
    @DisplayName("동적 데이터 소스를 성공적으로 바인딩")
    public void shouldSetDynamicDataSourceSuccessfully() throws Exception {
        String dbUrl = "jdbc:h2:mem:testdb";
        String dbUsername = "sa";
        String dbPassword = "";
        String driverClassName = "org.h2.Driver";
        String namespace = "testnamespace";

        dynamicDatabaseService.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
        assertEquals(namespace, DatabaseConfig.getNamespace());
    }


    @Test
    @DisplayName("testOne 쿼리가 올바른 값을 반환")
    public void testGetTestOne() {
        Integer result = indexRepository.getTestOne();
        assertNotNull(result);
        assertEquals(1, result);
    }
    @Test
    @DisplayName("잘못된 데이터베이스 주소의 경우 적절한 예외처리")
    public void shouldThrowExceptionForInvalidDatabaseUrl() {
        String invalidDbUrl = "invalid_url";
        String dbUsername = "user";
        String dbPassword = "password";
        String driverClassName = "org.h2.Driver";
        String namespace = "com.example.spectra.mapper";

        Exception exception = assertThrows(Exception.class, () -> {
            dynamicDatabaseService.setDynamicDataSource(invalidDbUrl, dbUsername, dbPassword, driverClassName, namespace);
        });

        assertTrue(exception.getMessage().contains("Invalid database URL"));
    }
}