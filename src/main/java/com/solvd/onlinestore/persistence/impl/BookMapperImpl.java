package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.Book;
import com.solvd.onlinestore.persistence.BookRepository;
import com.solvd.onlinestore.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookMapperImpl implements BookRepository {


    @Override
    public void create(Long onlineStoreId, Long publishingHouseId, Book book) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            BookRepository bookRepository = sqlSession.getMapper(BookRepository.class);
            bookRepository.create(onlineStoreId, publishingHouseId, book);
        }
    }

    @Override
    public List<Book> findAll() {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            BookRepository bookRepository = sqlSession.getMapper(BookRepository.class);
            return bookRepository.findAll();
        }
    }

    @Override
    public void update(Book book) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            BookRepository bookRepository = sqlSession.getMapper(BookRepository.class);
            bookRepository.update(book);
        }
    }

    @Override
    public void delete(Long deleteId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            BookRepository bookRepository = sqlSession.getMapper(BookRepository.class);
            bookRepository.delete(deleteId);
        }
    }
}
