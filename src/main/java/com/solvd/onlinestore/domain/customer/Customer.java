package com.solvd.onlinestore.domain.customer;

import com.solvd.onlinestore.domain.onlinestore.ShoppingCart;
import com.solvd.onlinestore.domain.paymentmethod.Card;
import com.solvd.onlinestore.domain.paymentmethod.IPay;

public class Customer implements IEvent {

    private Long id;
    private String firstName;
    private String lastName;
    private ShoppingCart shoppingCart;
    private Contact contact;
    private Card card;
    private IPay payment;

    @Override
    public void onEvent(EventType type) {
        switch (type) {
            case SUBSCRIPTION:
                this.openSubscribe();
                this.notify(type);
                break;
            case NO_SUBSCRIPTION:
                this.closeSubscribe();
                this.notify(type);
                break;
            default:
                break;
        }
    }

    public void openSubscribe() {
        System.out.println("You have subscribed to our newsletter");
    }

    public void closeSubscribe() {
        System.out.println("Your subscription has been cancelled");
    }

    public void notify(EventType type) {
        switch (type) {
            case SUBSCRIPTION:
                System.out.println("You receive a message about the receipt of books, discounts and new products");
                break;
            case NO_SUBSCRIPTION:
                System.out.println("You don't get a message about the receipt of books, discounts and new products");
                break;
            default:
                break;
        }
    }

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

    public IPay getPayment() {
        return payment;
    }

    public void setPayment(IPay payment) {
        this.payment = payment;
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
                ", payment=" + payment +
                '}';
    }
}
