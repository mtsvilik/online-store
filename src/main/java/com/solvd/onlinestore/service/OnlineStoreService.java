package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.onlinestore.OnlineStore;

import java.util.Optional;

public interface OnlineStoreService {

    OnlineStore create(Long adminId, OnlineStore onlineStore);

    Optional<OnlineStore> getByName(String name);

    void update(OnlineStore onlineStore);

    void delete(Long deleteId);

}
