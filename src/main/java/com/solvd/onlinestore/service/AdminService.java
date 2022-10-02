package com.solvd.onlinestore.service;

import com.solvd.onlinestore.domain.Admin;

import java.math.BigDecimal;

public interface AdminService {

    Admin create(Admin admin);

    boolean findAdminBySalary(BigDecimal salary);

    void update(Admin admin);

    void delete(Long deleteId);

}
