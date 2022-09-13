package com.solvd.onlinestore.personalinfo;

import com.solvd.onlinestore.book.Book;
import com.solvd.onlinestore.user.Customer;

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
}
