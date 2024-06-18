package com.example.spectra.repository.h2;


import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MaintenanceRepository {

    private static final String namespace = "com.example.spectra.mapper.MaintenanceMapper";
    private final SqlSession sqlSession;

}
