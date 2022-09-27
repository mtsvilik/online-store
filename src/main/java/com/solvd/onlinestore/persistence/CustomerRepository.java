package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {

    void create(Long contactId, Long cardId, Customer customer);

    Optional<Customer> findByLastName(String lastName);

    void update(Customer customer);

    void delete(Long deleteId);

}
