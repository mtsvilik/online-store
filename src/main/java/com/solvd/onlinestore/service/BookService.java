package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.book.Book;

import java.util.List;

public interface BookService {

    Book create(Long onlineStoreId, Long publishingHouseId, Book book);

    List<Book> getById(Long id);

    Book getBookById(Long id);

    List<Book> getAll();

    void update(Book book);

    void delete(Long deleteId);

}
