package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.onlinestore.Admin;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.ConnectionPool;

import java.sql.*;
import java.util.Optional;

public class AdminRepositoryImpl implements AdminRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Admin admin) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "insert into admins(first_name, last_name, salary) " +
                "values (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertInto, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, admin.getFirstName());
            preparedStatement.setString(2, admin.getLastName());
            preparedStatement.setBigDecimal(3, admin.getSalary());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                admin.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create an admin", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Admin> findByLastName(String lastName) {
        Admin result = null;
        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select id from admins where last_name = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new Admin();
                result.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find admin by admin's last name", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void update(Admin admin) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update admins set last_name = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, admin.getLastName());
            preparedStatement.setLong(2, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataUpdateException("Can't update an admin", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long deleteId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from admins where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setLong(1, deleteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataDeleteException("Can't delete an admin", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
