package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.onlinestore.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface AdminRepository {

    void create(Admin admin);

    Admin findById(Long id);

    Optional<Admin> findByLastName(String lastName);

    void update(@Param("id") Long id, @Param("lastName") String lastName);

    void delete(Long deleteId);

}
