package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface CustomerRepository {

    void create(@Param("contactId") Long contactId, @Param("cardId") Long cardId, @Param("customer") Customer customer);

    Optional<Customer> findByLastName(String lastName);

    void update(Customer customer);

    void delete(Long deleteId);

}
