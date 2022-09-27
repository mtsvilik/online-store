package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.Admin;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.AdminRepository;
import com.solvd.onlinestore.persistence.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;

public class AdminRepositoryImpl implements AdminRepository {

    private static final Logger LOGGER = LogManager.getLogger(AdminRepositoryImpl.class);

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Admin admin) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "insert into " +
                "admins(first_name, last_name, salary) " +
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
    public boolean findAdminBySalary(BigDecimal salary) {
        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select salary from admins where salary = ?";
        boolean exists = false;
        try (PreparedStatement statement = connection.prepareStatement(select)) {
            statement.setString(1, String.valueOf(salary));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exists = true;
            }
            LOGGER.info("salary exists? {}", exists);
            return exists;
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find admin by salary", e);
        }
    }

    @Override
    public void update(Admin admin) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update admins set last_name = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setLong(1, admin.getId());
            preparedStatement.setString(2, admin.getLastName());
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
