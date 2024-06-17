package com.example.spectra.service;


import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.repository.dynamic.IndexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
//@MybatisTest
public class DynamicDatabaseServiceTest {
    private DynamicDatabaseService dynamicDatabaseService;
    private DynamicDataSourceConfig dynamicDataSourceConfig;
    private IndexRepository indexRepository;
    @Autowired
    private ApplicationContext applicationContext;
    @BeforeEach
    public void setUp() throws Exception {
        dynamicDataSourceConfig = new DynamicDataSourceConfig(applicationContext);
        dynamicDatabaseService = new DynamicDatabaseService(dynamicDataSourceConfig);
        indexRepository = new IndexRepository();

        String dbUrl = "jdbc:log4jdbc:postgresql://dev-jun.cue2lnhpxxlj.ap-northeast-2.rds.amazonaws.com:5432/postgres?currentSchema=public";
        String dbUsername = "postgres";
        String dbPassword = "Rkdwnsgur3##";
        String driverClassName = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
        String namespace = "postgres";
        dynamicDatabaseService.setDynamicDataSource(dbUrl, dbUsername, dbPassword, driverClassName, namespace);
    }

    @Test
    @DisplayName("동적 데이터 소스를 성공적으로 바인딩")
    public void shouldSetDynamicDataSourceSuccessfully() {
        SqlSessionTemplate sqlSessionTemplate = dynamicDataSourceConfig.getDynamicSqlSessionTemplate();
        assertNotNull(sqlSessionTemplate);
        assertEquals("com.example.spectra.mapper.postgres", DynamicDataSourceConfig.getNamespace());
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
        String namespace = "postgres";

        Exception exception = assertThrows(Exception.class, () -> {
            dynamicDatabaseService.setDynamicDataSource(invalidDbUrl, dbUsername, dbPassword, driverClassName, namespace);
        });

        assertTrue(exception.getMessage().contains("Failed to set dynamic data source"));
    }
}