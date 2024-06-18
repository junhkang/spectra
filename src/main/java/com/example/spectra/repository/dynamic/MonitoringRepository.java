package com.example.spectra.repository.dynamic;

import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.config.database.SqlSessionTemplateAware;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MonitoringRepository implements SqlSessionTemplateAware {
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

}
