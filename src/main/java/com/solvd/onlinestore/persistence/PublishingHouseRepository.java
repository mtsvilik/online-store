package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.PublishingHouse;

import java.util.Optional;

public interface PublishingHouseRepository {

    void create(PublishingHouse publishingHouse);

    Optional<PublishingHouse> findByName(String name);

    void update(PublishingHouse publishingHouse);

    void delete(Long deleteId);

}
