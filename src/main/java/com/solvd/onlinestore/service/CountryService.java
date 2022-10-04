package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.Country;

import java.util.Optional;

public interface CountryService {

    Country create(Country country);

    Optional<Country> getByName(String name);

}
