package com.solvd.onlinestore.domain.onlinestore;

import com.solvd.onlinestore.domain.book.Book;
import com.solvd.onlinestore.domain.customer.Customer;

import java.util.List;

public class OnlineStore {

    private Long id;
    private String name;
    private Admin admin;
    private List<Book> books;
    private List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "OnlineStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", admin=" + admin +
                ", books=" + books +
                ", customers=" + customers +
                '}';
    }
}