package com.example.spectra.config.database;


import lombok.Getter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Getter
@Component
public class DynamicDataSourceConfig {

    private SqlSessionTemplate dynamicSqlSessionTemplate;

    public void setDynamicDataSource(String dbUrl, String dbUsername, String dbPassword, String driverClassName, String mapperLocation) throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(driverClassName);

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));

        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();
        this.dynamicSqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    }

}