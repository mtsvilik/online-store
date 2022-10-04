package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.Customer;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.ConnectionPool;
import com.solvd.onlinestore.persistence.CustomerRepository;

import java.sql.*;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Long contactId, Long cardId, Customer customer) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "insert into customers (contact_id, card_id, first_name, last_name) " +
                "values (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertInto, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, contactId);
            preparedStatement.setLong(2, cardId);
            preparedStatement.setString(3, customer.getFirstName());
            preparedStatement.setString(4, customer.getLastName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                customer.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create a customer", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Customer> findByLastName(String lastName) {
        Customer result = null;
        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select id from customers where last_name = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new Customer();
                result.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find customer by customer's last name", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void update(Customer customer) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update customers set last_name = ? where id = ?; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, customer.getLastName());
            preparedStatement.setLong(2, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataUpdateException("Can't update a customer", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long deleteId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from customers where id = ?; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setLong(1, deleteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataDeleteException("Can't delete a customer", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
