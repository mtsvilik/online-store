package com.solvd.onlinestore.persistence.impl;

import com.solvd.onlinestore.domain.author.Author;
import com.solvd.onlinestore.domain.author.Country;
import com.solvd.onlinestore.domain.book.Book;
import com.solvd.onlinestore.domain.book.Book.Genre;
import com.solvd.onlinestore.domain.book.PublishingHouse;
import com.solvd.onlinestore.domain.book.Sale;
import com.solvd.onlinestore.domain.exception.DataCreateException;
import com.solvd.onlinestore.domain.exception.DataDeleteException;
import com.solvd.onlinestore.domain.exception.DataNotFoundException;
import com.solvd.onlinestore.domain.exception.DataUpdateException;
import com.solvd.onlinestore.persistence.BookRepository;
import com.solvd.onlinestore.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String FIND_ALL_BOOKS_PUBLISHING_HOUSES_AUTHORS = "select " +
            "b.id as book_id, b.name as book_name, b.genre as book_genre, " +
            "b.bestseller as book_bestseller, b.sale as book_sale, b.price as book_price, " +
            "ph.id as publishing_house_id, ph.name as publishing_house_name, " +
            "a.id as author_id, a.first_name as author_first_name, a.last_name as author_last_name, " +
            "c.id as country_id, c.name as country_name, c.code as country_code " +
            "from books b " +
            "left join publishing_houses ph " +
            "on b.publishing_house_id = ph.id " +
            "left join author_books ab " +
            "on b.id = ab.book_id " +
            "left join authors a " +
            "on ab.author_id = a.id " +
            "left join countries c " +
            "on a.country_id = c.id ";

    @Override
    public void create(Long onlineStoreId, Long publishingHouseId, Book book) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insertInto = "Insert into " +
                "books(online_store_id, publishing_house_id, name, genre, bestseller, sale, price)" +
                "values (?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertInto, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, onlineStoreId);
            preparedStatement.setLong(2, publishingHouseId);
            preparedStatement.setString(3, book.getName());
            preparedStatement.setString(4, String.valueOf(book.getGenre()));
            preparedStatement.setString(5, String.valueOf(book.getBestseller()));
            preparedStatement.setString(6, String.valueOf(book.getSale()));
            preparedStatement.setBigDecimal(7, book.getPrice());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                book.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create a book", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BOOKS_PUBLISHING_HOUSES_AUTHORS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            books = mapBooks(resultSet);
        } catch (SQLException e) {
            throw new DataNotFoundException("Can't find books, publishing houses, or authors", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return books;
    }

    private static List<Book> mapBooks(ResultSet resultSet) {
        List<Book> books = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Long id = resultSet.getLong("book_id");
                Book book = findById(id, books);
                book.setName(resultSet.getString("book_name"));
                book.setGenre(Genre.valueOf(resultSet.getString("book_genre")));
                book.setBestseller(Book.Bestseller.valueOf(resultSet.getString("book_bestseller")));
                book.setSale(Sale.valueOf(resultSet.getString("book_sale")));
                book.setPrice(resultSet.getBigDecimal("book_price"));
                Author author = new Author();
                author.setId(resultSet.getLong("author_id"));
                author.setFirstName(resultSet.getString("author_first_name"));
                author.setLastName(resultSet.getString("author_last_name"));
                Country country = new Country();
                country.setId(resultSet.getLong("country_id"));
                country.setName(resultSet.getString("country_name"));
                country.setCode(resultSet.getString("country_code"));
                author.setCountry(country);
                book.setAuthor(author);
                PublishingHouse publishingHouse = new PublishingHouse();
                publishingHouse.setId(resultSet.getLong("publishing_house_id"));
                publishingHouse.setName(resultSet.getString("publishing_house_name"));
                book.setPublishingHouse(publishingHouse);
            }
        } catch (SQLException e) {
            throw new DataCreateException("Can't create a map", e);
        }
        return books;
    }

    private static Book findById(Long id, List<Book> books) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Book createdBook = new Book();
                    createdBook.setId(id);
                    books.add(createdBook);
                    return createdBook;
                });
    }

    @Override
    public void update(Book book) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update books set name = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setLong(2, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataUpdateException("Can't update a book", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long deleteId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from books where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setLong(1, deleteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataDeleteException("Can't delete a book", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}