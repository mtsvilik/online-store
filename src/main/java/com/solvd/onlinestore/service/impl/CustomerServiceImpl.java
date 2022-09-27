package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Customer;
import com.solvd.onlinestore.persistence.CustomerRepository;
import com.solvd.onlinestore.persistence.impl.CustomerRepositoryImpl;
import com.solvd.onlinestore.service.CustomerService;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepositoryImpl();
    }

    @Override
    public Customer create(Long contactId, Long cardId, Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findByLastName(String lastName) {
        return Optional.empty();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void delete(Long deleteId) {
        customerRepository.delete(deleteId);
    }
}
