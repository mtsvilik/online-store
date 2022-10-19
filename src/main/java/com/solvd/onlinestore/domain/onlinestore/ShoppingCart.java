package com.solvd.onlinestore.domain.onlinestore;

import com.solvd.onlinestore.domain.book.Book;

import java.util.List;

public class ShoppingCart {

    private Long id;
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }
}
