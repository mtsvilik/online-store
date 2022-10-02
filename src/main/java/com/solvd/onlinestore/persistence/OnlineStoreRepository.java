package com.solvd.onlinestore.persistence;

import com.solvd.onlinestore.domain.OnlineStore;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface OnlineStoreRepository {

    void create(@Param("adminId") Long adminId, @Param("onlineStore") OnlineStore onlineStore);

    Optional<OnlineStore> findByName(String name);

    void update(OnlineStore onlineStore);

    void delete(Long deleteId);

}
