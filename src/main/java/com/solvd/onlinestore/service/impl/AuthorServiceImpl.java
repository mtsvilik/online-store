package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.author.Author;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.persistence.AuthorRepository;
import com.solvd.onlinestore.persistence.impl.AuthorMapperImpl;
import com.solvd.onlinestore.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl() {
        this.authorRepository = new AuthorMapperImpl();
    }

    @Override
    public Author create(Long countryId, Author author) {
        author.setId(null);
        authorRepository.create(countryId, author);
        return author;
    }

    @Override
    public Author getByLastName(String lastName) {
        return authorRepository.findByLastName(lastName)
                .orElseThrow(() -> new DataNotFoundException("Author not found"));
    }
}
