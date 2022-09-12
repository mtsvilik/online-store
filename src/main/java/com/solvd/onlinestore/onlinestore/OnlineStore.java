package com.solvd.onlinestore.onlinestore;

import com.solvd.onlinestore.human.Admin;
import com.solvd.onlinestore.shoppingcart.ShoppingCart;
import com.solvd.onlinestore.book.Book;
import com.solvd.onlinestore.human.Customer;

import java.util.List;

public class OnlineStore {

    private Long id;
    private String title;
    private Bestseller bestseller;
    private Sale sale;
    private ShoppingCart shoppingCart;
    private Admin admin;
    private List<Book> books;
    private List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bestseller getBestseller() {
        return bestseller;
    }

    public void setBestseller(Bestseller bestseller) {
        this.bestseller = bestseller;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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
}