package com.example.spectra.repository.dynamic;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class IndexRepository {
    @Setter
    private String namespace;
    private final SqlSession sqlSession;

    public IndexRepository(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

}
