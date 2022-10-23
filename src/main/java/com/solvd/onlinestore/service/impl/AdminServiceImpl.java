package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.onlinestore.Admin;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.impl.AdminMapperImpl;
import com.solvd.onlinestore.service.AdminService;

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
    public Admin getById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin getByLastName(String lastName) {
        return adminRepository.findByLastName(lastName)
                .orElseThrow(() -> new DataNotFoundException("Admin not found"));
    }

    @Override
    public void update(Long id, String lastName) {
        adminRepository.update(id, lastName);
    }

    @Override
    public void delete(Long deleteId) {
        adminRepository.delete(deleteId);
    }
}
