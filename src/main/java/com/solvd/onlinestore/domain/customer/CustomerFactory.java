package com.solvd.onlinestore.domain.customer;

public class CustomerFactory {

    public static Customer getCustomer(CustomerType type) {
        Customer customer = null;
        switch (type) {
            case NEW_CUSTOMER:
                customer = new NewCustomer();
                break;
            case REGULAR_CUSTOMER:
                customer = new RegularCustomer();
                break;
            default:
                throw new UnsupportedOperationException("This operation is not supported for the customer");
        }
        return customer;
    }
}
