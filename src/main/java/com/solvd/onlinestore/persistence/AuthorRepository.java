package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Author;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface AuthorRepository {

    void create(@Param("countryId") Long countryId, @Param("author") Author author);

    Optional<Author> findByLastName(String lastName);

}
