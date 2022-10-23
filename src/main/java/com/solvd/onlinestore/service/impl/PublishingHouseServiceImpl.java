package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.book.PublishingHouse;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.persistence.PublishingHouseRepository;
import com.solvd.onlinestore.persistence.impl.PublishingHouseMapperImpl;
import com.solvd.onlinestore.service.PublishingHouseService;

public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseRepository publishingHouseRepository;

    public PublishingHouseServiceImpl() {
        //this.publishingHouseRepository = new PublishingHouseRepositoryImpl();
        this.publishingHouseRepository = new PublishingHouseMapperImpl();
    }

    @Override
    public PublishingHouse create(PublishingHouse publishingHouse) {
        publishingHouse.setId(null);
        publishingHouseRepository.create(publishingHouse);
        return publishingHouse;
    }

    @Override
    public PublishingHouse getByName(String name) {
        return publishingHouseRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException("Publishing house not found"));
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        publishingHouseRepository.update(publishingHouse);
    }

    @Override
    public void delete(Long deleteId) {
        publishingHouseRepository.delete(deleteId);
    }
}


