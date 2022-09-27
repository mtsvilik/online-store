package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.PublishingHouse;

import java.util.Optional;

public interface PublishingHouseService {

    PublishingHouse create(PublishingHouse publishingHouse);

    Optional<PublishingHouse> getByName(String name);

    void update(PublishingHouse publishingHouse);

    void delete(Long deleteId);

}
