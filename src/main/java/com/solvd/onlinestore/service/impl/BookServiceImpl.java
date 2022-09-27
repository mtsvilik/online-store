package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Book;
import com.solvd.onlinestore.persistence.BookRepository;
import com.solvd.onlinestore.persistence.impl.BookRepositoryImpl;
import com.solvd.onlinestore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepositoryImpl();
    }


    @Override
    public Book create(Long onlineStoreId, Long publishingHouseId, Book book) {
        return null;
    }

    @Override
    public List<Book> getAll() {
       return bookRepository.findAll();
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    public void delete(Long deleteId) {
        bookRepository.delete(deleteId);
    }
}
