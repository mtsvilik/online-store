package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.onlinestore.OnlineStore;

public interface OnlineStoreService {

    OnlineStore create(Long adminId, OnlineStore onlineStore);

    OnlineStore getByName(String name);

    void update(OnlineStore onlineStore);

    void delete(Long deleteId);

}
