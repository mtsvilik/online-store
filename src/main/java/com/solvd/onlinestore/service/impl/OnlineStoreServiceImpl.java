package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Admin;
import com.solvd.onlinestore.domain.OnlineStore;
import com.solvd.onlinestore.persistence.OnlineStoreRepository;
import com.solvd.onlinestore.persistence.impl.OnlineStoreRepositoryImpl;
import com.solvd.onlinestore.service.AdminService;
import com.solvd.onlinestore.service.OnlineStoreService;

import java.util.Optional;

public class OnlineStoreServiceImpl implements OnlineStoreService {

    private final OnlineStoreRepository onlineStoreRepository;
    private final AdminService adminService;

    public OnlineStoreServiceImpl() {
        this.onlineStoreRepository = new OnlineStoreRepositoryImpl();
        this.adminService = new AdminServiceImpl();
    }

    @Override
    public OnlineStore create(OnlineStore onlineStore) {
        onlineStore.setId(null);
        onlineStoreRepository.create(onlineStore);
        if (onlineStore.getAdmin() != null) {
            Admin admin = adminService.create(onlineStore.getAdmin());
            onlineStore.setAdmin(admin);
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
