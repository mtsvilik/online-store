package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer create(Long contactId, Long cardId, Customer customer);

    Optional<Customer> getByLastName(String lastName);

    void update(Customer customer);

    void delete(Long deleteId);

}
