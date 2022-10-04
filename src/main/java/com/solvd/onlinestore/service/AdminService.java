package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.Admin;

import java.util.Optional;

public interface AdminService {

    Admin create(Admin admin);

    Optional<Admin> getByLastName(String lastName);

    void update(Admin admin);

    void delete(Long deleteId);

}
