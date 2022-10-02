package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Admin;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.impl.AdminMapperImpl;
import com.solvd.onlinestore.persistence.impl.AdminRepositoryImpl;
import com.solvd.onlinestore.service.AdminService;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl() {
        //this.adminRepository = new AdminRepositoryImpl();
        this.adminRepository = new AdminMapperImpl();
    }

    @Override
    public Admin create(Admin admin) {
        admin.setId(null);
        adminRepository.create(admin);
        return admin;
    }

    @Override
    public Optional<Admin> getByLastName(String lastName) {
        return adminRepository.findByLastName(lastName);
    }

    @Override
    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    @Override
    public void delete(Long deleteId) {
        adminRepository.delete(deleteId);
    }
}
