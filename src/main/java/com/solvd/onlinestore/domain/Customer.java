package com.solvd.onlinestore.domain;

import com.solvd.onlinestore.domain.Card;
import com.solvd.onlinestore.domain.Contact;
import com.solvd.onlinestore.domain.ShoppingCart;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private ShoppingCart shoppingCart;
    private Contact contact;
    private Card card;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", contact=" + contact +
                ", card=" + card +
                '}';
    }
}
