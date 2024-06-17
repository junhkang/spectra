package com.example.spectra.repository.dynamic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndexRepository implements SqlSessionTemplateAware {

    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    public Integer getTestOne() {
        return sqlSessionTemplate.selectOne(DynamicDataSourceConfig.getNamespace() + ".IndexMapper.testOne");
    }

}
