package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Admin;

import java.math.BigDecimal;

public interface AdminRepository {

    void create(Admin admin);

    boolean findAdminBySalary(BigDecimal salary);

    void update(Admin admin);

    void delete(Long deleteId);

}
