package com.example.spectra.config.database;

import org.mybatis.spring.SqlSessionTemplate;

public interface SqlSessionTemplateAware {
    void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate);
}
