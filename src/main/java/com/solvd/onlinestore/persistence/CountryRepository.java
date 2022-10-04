package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Country;

import java.util.Optional;

public interface CountryRepository {

    void create(Country country);

    Optional<Country> findByName(String name);

}
