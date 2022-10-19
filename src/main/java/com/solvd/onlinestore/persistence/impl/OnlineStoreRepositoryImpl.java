package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.onlinestore.OnlineStore;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.ConnectionPool;
import com.solvd.onlinestore.persistence.OnlineStoreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OnlineStoreRepositoryImpl implements OnlineStoreRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Long adminId, OnlineStore onlineStore) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "insert into online_stores (admin_id, name) values (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertInto, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, adminId);
            preparedStatement.setString(2, onlineStore.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                onlineStore.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create an online store", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<OnlineStore> findByName(String name) {
        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select id from online_stores where name = ? ";
        OnlineStore result = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new OnlineStore();
                result.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find online store by name", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.ofNullable(result);
    }

    private static List<OnlineStore> mapOnlineStores(ResultSet resultSet) {
        List<OnlineStore> onlineStores = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Long id = resultSet.getLong("admin_id");
                OnlineStore onlineStore = findById(id, onlineStores);
                onlineStore.setName(resultSet.getString("online_store_name"));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create a map", e);
        }
        return onlineStores;
    }

    private static OnlineStore findById(Long id, List<OnlineStore> onlineStores) {
        return onlineStores.stream()
                .filter(onlineStore -> onlineStore.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    OnlineStore createdOnlineStore = new OnlineStore();
                    createdOnlineStore.setId(id);
                    onlineStores.add(createdOnlineStore);
                    return createdOnlineStore;
                });
    }

    @Override
    public void update(OnlineStore onlineStore) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update online_stores set name = ? where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, onlineStore.getName());
            preparedStatement.setLong(2, onlineStore.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataUpdateException("Can't update an online store", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long deleteId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from online_stores where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setLong(1, deleteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataDeleteException("Can't delete an online store", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
