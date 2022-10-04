package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.Customer;
import com.solvd.onlinestore.persistence.CustomerRepository;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class CustomerMapperImpl implements CustomerRepository {

    @Override
    public void create(Long contactId, Long cardId, Customer customer) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.create(contactId, cardId, customer);
        }
    }

    @Override
    public Optional<Customer> findByLastName(String lastName) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            return customerRepository.findByLastName(lastName);
        }
    }

    @Override
    public void update(Customer customer) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.update(customer);
        }
    }

    @Override
    public void delete(Long deleteId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.delete(deleteId);
        }
    }
}
