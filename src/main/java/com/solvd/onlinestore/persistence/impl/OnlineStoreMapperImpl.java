package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.OnlineStore;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import com.solvd.onlinestore.persistence.OnlineStoreRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class OnlineStoreMapperImpl implements OnlineStoreRepository {

    @Override
    public void create(Long adminId, OnlineStore onlineStore) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OnlineStoreRepository onlineStoreRepository = sqlSession.getMapper(OnlineStoreRepository.class);
            onlineStoreRepository.create(adminId, onlineStore);
        }
    }

    @Override
    public Optional<OnlineStore> findByName(String name) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OnlineStoreRepository onlineStoreRepository = sqlSession.getMapper(OnlineStoreRepository.class);
            return onlineStoreRepository.findByName(name);
        }
    }

    @Override
    public void update(OnlineStore onlineStore) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OnlineStoreRepository onlineStoreRepository = sqlSession.getMapper(OnlineStoreRepository.class);
            onlineStoreRepository.update(onlineStore);
        }
    }

    @Override
    public void delete(Long deleteId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            OnlineStoreRepository onlineStoreRepository = sqlSession.getMapper(OnlineStoreRepository.class);
            onlineStoreRepository.delete(deleteId);
        }
    }
}
