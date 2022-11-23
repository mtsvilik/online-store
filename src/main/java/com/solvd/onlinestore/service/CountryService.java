package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.author.Country;

public interface CountryService {

    Country create(Country country);

    Country getByName(String name);

}
