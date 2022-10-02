package com.solvd.onlinestore.service.impl;

import com.solvd.onlinestore.domain.Admin;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.impl.AdminRepositoryImpl;
import com.solvd.onlinestore.service.AdminService;

import java.math.BigDecimal;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl() {
        this.adminRepository = new AdminRepositoryImpl();
    }

    @Override
    public Admin create(Admin admin) {
        admin.setId(null);
        adminRepository.create(admin);
        return admin;
    }

    @Override
    public boolean findAdminBySalary(BigDecimal salary) {
        return false;
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
