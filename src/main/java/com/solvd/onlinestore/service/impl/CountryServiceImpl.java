package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Country;
import com.solvd.onlinestore.persistence.CountryRepository;
import com.solvd.onlinestore.persistence.impl.CountryMapperImpl;
import com.solvd.onlinestore.service.CountryService;

import java.util.Optional;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl() {
        this.countryRepository = new CountryMapperImpl();
    }

    @Override
    public Country create(Country country) {
        country.setId(null);
        countryRepository.create(country);
        return country;
    }

    @Override
    public Optional<Country> getByName(String name) {
        return countryRepository.findByName(name);
    }
}
