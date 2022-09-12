package com.solvd.onlinestore.shoppingcart;

import com.solvd.onlinestore.book.Book;
import com.solvd.onlinestore.human.Customer;

import java.util.List;

public class ShoppingCart {

    private Long id;
    private Customer customer;
    private List<Book> book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
