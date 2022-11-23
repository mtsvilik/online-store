package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.book.PublishingHouse;

public interface PublishingHouseService {

    PublishingHouse create(PublishingHouse publishingHouse);

    PublishingHouse getByName(String name);

    void update(PublishingHouse publishingHouse);

    void delete(Long deleteId);

}
