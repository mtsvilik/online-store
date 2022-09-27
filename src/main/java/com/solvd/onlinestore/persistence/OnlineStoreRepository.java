package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.OnlineStore;

import java.util.Optional;

public interface OnlineStoreRepository {

    void create(OnlineStore onlineStore);

    Optional<OnlineStore> findByName(String name);

    void update(OnlineStore onlineStore);

    void delete(Long deleteId);

}
