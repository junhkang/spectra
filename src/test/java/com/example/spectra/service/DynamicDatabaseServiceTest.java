package com.example.spectra.service;


import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.repository.dynamic.IndexRepository;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DynamicDatabaseServiceTest {

    @InjectMocks
    private DynamicDatabaseService dynamicDatabaseService;
    @InjectMocks
    private IndexRepository indexRepository;

    @Mock
    private DynamicDataSourceConfig dynamicDataSourceConfig;
    @Mock
    private SqlSession sqlSession;
    @Mock
    private SqlSessionTemplate sqlSessionTemplate;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(dynamicDataSourceConfig.getDynamicSqlSessionTemplate()).thenReturn(sqlSessionTemplate);

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
        assertEquals("com.example.spectra.mapper." + namespace, DynamicDataSourceConfig.getNamespace());
    }
    @Test
    @DisplayName("testOne 쿼리가 올바른 값을 반환")
    public void testGetTestOne() throws Exception {

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