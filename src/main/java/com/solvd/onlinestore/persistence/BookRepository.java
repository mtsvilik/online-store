package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookRepository {

    void create(@Param("onlineStoreId") Long onlineStoreId, @Param("publishingHouseId") Long publishingHouseId, @Param("book") Book book);

    List<Book> findAll();

    void update(Book book);

    void delete(Long deleteId);

}
