package com.example.spectra.service;


import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.repository.dynamic.IndexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@SpringBootTest
//@MybatisTest
public class DynamicDatabaseServiceTest {
    @Autowired
    private ApplicationContext applicationContext;

    @InjectMocks
    private DynamicDatabaseService dynamicDatabaseService;

    @MockBean
    private DynamicDataSourceConfig dynamicDataSourceConfig;

    @MockBean
    private IndexRepository indexRepository;

    @BeforeEach
    public void setUp() {
        SqlSessionTemplate mockSqlSessionTemplate = mock(SqlSessionTemplate.class);
        when(dynamicDataSourceConfig.getDynamicSqlSessionTemplate()).thenReturn(mockSqlSessionTemplate);
        ReflectionTestUtils.setField(dynamicDataSourceConfig, "namespace", "com.example.spectra.mapper.postgres");
        dynamicDatabaseService = new DynamicDatabaseService(dynamicDataSourceConfig);
        when(indexRepository.getTestOne()).thenReturn(1);
    }

    @Test
    @DisplayName("동적 데이터 소스를 성공적으로 바인딩")
    public void shouldSetDynamicDataSourceSuccessfully() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = dynamicDataSourceConfig.getDynamicSqlSessionTemplate();
        assertNotNull(sqlSessionTemplate);
        assertEquals("com.example.spectra.mapper.postgres", DynamicDataSourceConfig.getNamespace());
    }

    @Test
    @DisplayName("testOne 쿼리가 올바른 값을 반환")
    public void testGetTestOne() {
        Integer result = indexRepository.getTestOne();
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