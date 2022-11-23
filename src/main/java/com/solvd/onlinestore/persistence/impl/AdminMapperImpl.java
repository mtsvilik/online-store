package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.onlinestore.Admin;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class AdminMapperImpl implements AdminRepository {

    @Override
    public void create(Admin admin) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.create(admin);
        }
    }

    @Override
    public Admin findById(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            return adminRepository.findById(id);
        }
    }

    @Override
    public Optional<Admin> findByLastName(String lastName) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            return adminRepository.findByLastName(lastName);
        }
    }

    @Override
    public void update(Long id, String lastName) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.update(id, lastName);
        }
    }

    @Override
    public void delete(Long deleteId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
            adminRepository.delete(deleteId);
        }
    }
}
