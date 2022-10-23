package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.customer.Customer;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.persistence.CustomerRepository;
import com.solvd.onlinestore.persistence.impl.CustomerMapperImpl;
import com.solvd.onlinestore.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        //this.customerRepository = new CustomerRepositoryImpl();
        this.customerRepository = new CustomerMapperImpl();
    }

    @Override
    public Customer create(Long contactId, Long cardId, Customer customer) {
        customer.setId(null);
        customerRepository.create(contactId, cardId, customer);
        return customer;
    }

    @Override
    public Customer getByLastName(String lastName) {
        return customerRepository.findByLastName(lastName)
                .orElseThrow(() -> new DataNotFoundException("Customer not found"));
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
