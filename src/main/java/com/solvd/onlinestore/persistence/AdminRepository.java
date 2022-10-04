package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Admin;

import java.util.Optional;

public interface AdminRepository {

    void create(Admin admin);

    Optional<Admin> findByLastName(String lastName);

    void update(Admin admin);

    void delete(Long deleteId);

}
