package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.author.Country;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.persistence.CountryRepository;
import com.solvd.onlinestore.persistence.impl.CountryMapperImpl;
import com.solvd.onlinestore.service.CountryService;

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
    public Country getByName(String name) {
        return countryRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException("Country not found"));
    }
}
