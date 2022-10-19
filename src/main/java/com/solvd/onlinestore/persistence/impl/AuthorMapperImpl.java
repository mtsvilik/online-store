package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.author.Author;
import com.solvd.onlinestore.persistence.AuthorRepository;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;


public class AuthorMapperImpl implements AuthorRepository {

    @Override
    public void create(Long countryId, Author author) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AuthorRepository authorRepository = sqlSession.getMapper(AuthorRepository.class);
            authorRepository.create(countryId, author);
        }
    }

    @Override
    public Optional<Author> findByLastName(String lastName) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            AuthorRepository authorRepository = sqlSession.getMapper(AuthorRepository.class);
            return authorRepository.findByLastName(lastName);
        }
    }
}
