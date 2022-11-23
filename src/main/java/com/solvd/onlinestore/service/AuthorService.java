package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.author.Author;

public interface AuthorService {

    Author create(Long countryId, Author author);

    Author getByLastName(String lastName);

}
