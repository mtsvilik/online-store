package com.solvd.onlinestore.domain.paymentmethod;

public class PayPal implements IPay {

    @Override
    public void pay() {
        System.out.println("Your payment was successful, thank you for choosing PayPal");
    }

}
