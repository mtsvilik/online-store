package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.onlinestore.Admin;

public interface AdminService {

    Admin create(Admin admin);

    Admin getById(Long id);

    Admin getByLastName(String lastName);

    void update(Long id, String lastName);

    void delete(Long deleteId);

}
