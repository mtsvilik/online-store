package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Book;

import java.util.List;

public interface BookRepository {

    void create(Long onlineStoreId, Long publishingHouseId, Book book);

    List<Book> findAll();

    void update(Book book);

    void delete(Long deleteId);

}
