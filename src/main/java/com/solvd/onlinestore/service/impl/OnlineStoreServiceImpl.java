package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.onlinestore.OnlineStore;
import com.solvd.onlinestore.persistence.OnlineStoreRepository;
import com.solvd.onlinestore.persistence.impl.OnlineStoreMapperImpl;
import com.solvd.onlinestore.service.OnlineStoreService;

public class OnlineStoreServiceImpl implements OnlineStoreService {

    private final OnlineStoreRepository onlineStoreRepository;

    public OnlineStoreServiceImpl() {
        //this.onlineStoreRepository = new OnlineStoreRepositoryImpl();
        this.onlineStoreRepository = new OnlineStoreMapperImpl();
    }

    @Override
    public OnlineStore create(Long adminId, OnlineStore onlineStore) {
        onlineStore.setId(null);
        onlineStoreRepository.create(adminId, onlineStore);
        return onlineStore;
    }

    @Override
    public OnlineStore getByName(String name) {
        return onlineStoreRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException("Online store not found"));
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
