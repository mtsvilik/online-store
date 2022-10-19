package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.author.Author;

import java.util.Optional;

public interface AuthorService {

    Author create(Long countryId, Author author);

    Optional<Author> getByLastName(String lastName);

}
