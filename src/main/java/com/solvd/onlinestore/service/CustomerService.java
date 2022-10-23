package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.customer.Customer;

public interface CustomerService {

    Customer create(Long contactId, Long cardId, Customer customer);

    Customer getByLastName(String lastName);

    void update(Customer customer);

    void delete(Long deleteId);

}
