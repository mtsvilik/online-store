package com.solvd.onlinestore.domain.paymentmethod;

public class PaymentMethodDecorator {

    private final Card card;
    private final PayPal payPal;

    public PaymentMethodDecorator() {
        card = new Card();
        payPal = new PayPal();
    }

    public void payWithCard() {
        card.pay();
    }

    public void payWithPayPal() {
        payPal.pay();
    }
}
