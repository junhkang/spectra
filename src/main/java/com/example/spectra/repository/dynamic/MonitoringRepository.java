package com.example.spectra.repository.dynamic;

import com.example.spectra.config.database.DynamicDataSourceConfig;
import com.example.spectra.config.database.SqlSessionTemplateAware;
import com.example.spectra.dto.IndexDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MonitoringRepository implements SqlSessionTemplateAware {
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    public List<IndexDTO> getUnusedIndexes(Map<String, Object> map) {
        return sqlSessionTemplate.selectList(DynamicDataSourceConfig.getNamespace() + ".MonitoringMapper.getUnusedIndexes", map);
    }
}
