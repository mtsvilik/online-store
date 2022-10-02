package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.PublishingHouse;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import com.solvd.onlinestore.persistence.PublishingHouseRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class PublishingHouseMapperImpl implements PublishingHouseRepository {


    @Override
    public void create(PublishingHouse publishingHouse) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            PublishingHouseRepository publishingHouseRepository = sqlSession.getMapper(PublishingHouseRepository.class);
            publishingHouseRepository.create(publishingHouse);
        }
    }

    @Override
    public Optional<PublishingHouse> findByName(String name) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            PublishingHouseRepository publishingHouseRepository = sqlSession.getMapper(PublishingHouseRepository.class);
            return publishingHouseRepository.findByName(name);
        }
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            PublishingHouseRepository publishingHouseRepository = sqlSession.getMapper(PublishingHouseRepository.class);
            publishingHouseRepository.update(publishingHouse);
        }
    }

    @Override
    public void delete(Long deleteId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            PublishingHouseRepository publishingHouseRepository = sqlSession.getMapper(PublishingHouseRepository.class);
            publishingHouseRepository.delete(deleteId);
        }
    }
}
