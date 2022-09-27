package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.OnlineStore;
import com.solvd.onlinestore.persistence.OnlineStoreRepository;
import com.solvd.onlinestore.persistence.impl.OnlineStoreRepositoryImpl;
import com.solvd.onlinestore.service.BookService;
import com.solvd.onlinestore.service.CustomerService;
import com.solvd.onlinestore.service.OnlineStoreService;

import java.util.Optional;

public class OnlineStoreServiceImpl implements OnlineStoreService {

    private final OnlineStoreRepository onlineStoreRepository;
    private final CustomerService customerService;
    private final BookService bookService;

    public OnlineStoreServiceImpl() {
        this.onlineStoreRepository = new OnlineStoreRepositoryImpl();
        this.customerService = new CustomerServiceImpl();
        this.bookService = new BookServiceImpl();
    }

    @Override
    public OnlineStore create(Long adminId, OnlineStore onlineStore) {
        onlineStore.setId(null);
        onlineStoreRepository.create(adminId, onlineStore);

        if (onlineStore.getBooks() != null) {
            onlineStore.getBooks()
                    .forEach(book -> bookService.create(onlineStore.getId(), book.getPublishingHouse().getId(), book));
        }

        if (onlineStore.getCustomers() != null) {
            onlineStore.getCustomers()
                    .forEach(customer -> customerService.create(customer.getContact().getId(), customer.getCard().getId(), customer));
        }
        return onlineStore;
    }

    @Override
    public Optional<OnlineStore> getByName(String name) {
        return onlineStoreRepository.findByName(name);
    }

    @Override
    public void update(OnlineStore onlineStore) {
        onlineStoreRepository.update(onlineStore);
    }

    @Override
    public void delete(Long deleteId) {
        onlineStoreRepository.delete(deleteId);
    }
}
