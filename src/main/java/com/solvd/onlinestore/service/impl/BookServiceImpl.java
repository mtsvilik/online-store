package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.book.Book;
import com.solvd.onlinestore.persistence.BookRepository;
import com.solvd.onlinestore.persistence.impl.BookMapperImpl;
import com.solvd.onlinestore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl() {
        //this.bookRepository = new BookRepositoryImpl();
        this.bookRepository = new BookMapperImpl();
    }

    @Override
    public Book create(Long onlineStoreId, Long publishingHouseId, Book book) {
        book.setId(null);
        bookRepository.create(onlineStoreId, publishingHouseId, book);
        return book;
    }

    @Override
    public List<Book> getById(Long id) {
        return bookRepository.findById(id);
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
