package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.author.Country;
import com.solvd.onlinestore.persistence.CountryRepository;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class CountryMapperImpl implements CountryRepository {

    @Override
    public void create(Country country) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            countryRepository.create(country);
        }
    }

    @Override
    public Optional<Country> findByName(String name) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            return countryRepository.findByName(name);
        }
    }
}
