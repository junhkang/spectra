package com.example.spectra.config.database;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

@Getter
@Setter
@Configuration
public class DynamicDataSourceConfig {
    private SqlSessionTemplate dynamicSqlSessionTemplate;

    private final ApplicationContext applicationContext;

    @Getter
    @Setter
    private static String namespace;

    public DynamicDataSourceConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void setDynamicDataSource(String dbUrl, String dbUsername, String dbPassword, String driverClassName, String namespace) throws Exception {
        try {
            validateDatabaseConnection(dbUrl, dbUsername, dbPassword, driverClassName);
            DriverManagerDataSource dataSource = createDataSource(dbUrl, dbUsername, dbPassword, driverClassName);
            SqlSessionFactory sqlSessionFactory = createSqlSessionFactory(dataSource, namespace);
            this.dynamicSqlSessionTemplate = new SqlSessionTemplate(Objects.requireNonNull(sqlSessionFactory));
            updateRepositories();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Failed to set dynamic data source", e);
        }
    }

    private DriverManagerDataSource createDataSource(String url, String username, String password, String driverClassName) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String namespace) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.example.spectra.dto");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/" + namespace + "/*.xml"));
        return sessionFactoryBean.getObject();
    }
    private void updateRepositories() {
        String[] beanNames = applicationContext.getBeanNamesForType(SqlSessionTemplateAware.class);
        for (String beanName : beanNames) {
            SqlSessionTemplateAware bean = (SqlSessionTemplateAware) applicationContext.getBean(beanName);
            bean.setSqlSessionTemplate(this.dynamicSqlSessionTemplate);
        }
    }
    private void validateDatabaseConnection(String dbUrl, String dbUsername, String dbPassword, String driverClassName) throws SQLException {
        try {
            Class.forName(driverClassName);
            try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
                if (connection == null || connection.isClosed()) {
                    throw new SQLException("Invalid database connection");
                }
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver class not found: " + driverClassName, e);
        } catch (SQLException e) {
            throw new SQLException("Invalid database connection: " + e.getMessage(), e);
        }
    }

}