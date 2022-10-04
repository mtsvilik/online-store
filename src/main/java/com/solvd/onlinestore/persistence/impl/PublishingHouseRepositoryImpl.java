package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.PublishingHouse;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.ConnectionPool;
import com.solvd.onlinestore.persistence.PublishingHouseRepository;

import java.sql.*;
import java.util.Optional;

public class PublishingHouseRepositoryImpl implements PublishingHouseRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(PublishingHouse publishingHouse) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "insert into publishing_houses name value ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertInto, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, publishingHouse.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                publishingHouse.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create a publishing house", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<PublishingHouse> findByName(String name) {
        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select id from publishing_houses where name = ? ";
        PublishingHouse result = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new PublishingHouse();
                result.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find publishing house by name", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update publishing_houses set name = ? where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setLong(1, publishingHouse.getId());
            preparedStatement.setString(2, publishingHouse.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataUpdateException("Can't update a publishing house", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long deleteId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from publishing_houses where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setLong(1, deleteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataDeleteException("Can't delete a publishing house", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
