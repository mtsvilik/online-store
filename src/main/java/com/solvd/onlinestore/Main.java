package com.solvd.onlinestore;

import com.solvd.onlinestore.domain.*;
import com.solvd.onlinestore.service.BookService;
import com.solvd.onlinestore.service.impl.BookServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Admin firstAdmin = new Admin();
        firstAdmin.setId(3L);
        firstAdmin.setFirstName("Vlad");
        firstAdmin.setLastName("Mihailov");
        firstAdmin.setSalary(BigDecimal.valueOf(1660));

        Admin secondAdmin = new Admin();
        secondAdmin.setFirstName("Den");
        secondAdmin.setLastName("Denisov");
        secondAdmin.setSalary(BigDecimal.valueOf(1500));

        Country firstCountry = new Country();
        firstCountry.setName("USA");
        firstCountry.setCode("USA840");

        Country secondCountry = new Country();
        secondCountry.setName("Russian Federation");
        secondCountry.setCode("RUS 643");

        Country thirdCountry = new Country();
        thirdCountry.setName("SWEDEN");
        thirdCountry.setCode("SWE 752");

        Author firstAuthor = new Author();
        firstAuthor.setFirstName("Fyodor");
        firstAuthor.setLastName("Dostoevsky");
        firstAuthor.setCountry(secondCountry);

        Author secondAuthor = new Author();
        secondAuthor.setFirstName("Loreth Anne");
        secondAuthor.setLastName("White");
        secondAuthor.setCountry(firstCountry);

        PublishingHouse firstPublishingHouse = new PublishingHouse();
        firstPublishingHouse.setName("OMG");

        Book firstBook = new Book();
        firstBook.setName("Crime and");
        firstBook.setAuthor(firstAuthor);
        firstBook.setGenre(Book.Genre.valueOf("FICTION"));
        firstBook.setBestseller(Book.Bestseller.valueOf("FOR_ALL_TIMES"));
        firstBook.setSale(Sale.valueOf("TWENTY_PERCENT"));
        firstBook.setPrice(BigDecimal.valueOf(88));

        Book secondBook = new Book();
        secondBook.setName("The Patient's Secret");
        secondBook.setAuthor(secondAuthor);
        secondBook.setGenre(Book.Genre.valueOf("FICTION"));
        secondBook.setBestseller(Book.Bestseller.valueOf("MONTH"));
        secondBook.setSale(Sale.valueOf("TWENTY_PERCENT"));
        secondBook.setPrice(BigDecimal.valueOf(90));

        List<Book> books = new ArrayList<>();
        books.add(firstBook);
        books.add(secondBook);

        ShoppingCart firstShoppingCart = new ShoppingCart();
        firstShoppingCart.setBooks(books);

        ShoppingCart secondShoppingCart = new ShoppingCart();
        secondShoppingCart.setBooks(books);

        Contact firstContact = new Contact();
        firstContact.setEmail("maxim.maximov@gmail.com");
        firstContact.setPassword("max12345");
        firstContact.setPhoneNumber(293609429);

        Contact secondContact = new Contact();
        secondContact.setEmail("irina.irinina@gmail.com");
        secondContact.setPassword("irina12345");
        secondContact.setPhoneNumber(293456754);

        Card firstCard = new Card();
        firstCard.setName("Visa");
        firstCard.setNumber(123456789);
        firstCard.setValidityPeriod(LocalDate.of(2024, 3, 15));

        Card secondCard = new Card();
        secondCard.setName("Master Card");
        secondCard.setNumber(987654321);
        secondCard.setValidityPeriod(LocalDate.of(2025, 10, 10));

        Customer firstCustomer = new Customer();
        firstCustomer.setId(20L);
        firstCustomer.setFirstName("Ekaterina");
        firstCustomer.setLastName("Moroz");
        firstCustomer.setShoppingCart(firstShoppingCart);
        firstCustomer.setContact(firstContact);
        firstCustomer.setCard(firstCard);

        Customer secondCustomer = new Customer();
        secondCustomer.setFirstName("Olga");
        secondCustomer.setLastName("Orlova");
        secondCustomer.setShoppingCart(secondShoppingCart);
        secondCustomer.setContact(secondContact);
        secondCustomer.setCard(secondCard);

        List<Customer> customers = new ArrayList<>();
        customers.add(firstCustomer);
        customers.add(secondCustomer);

        OnlineStore onlineStore = new OnlineStore();
        onlineStore.setId(15L);
        onlineStore.setName("Litres");
        onlineStore.setAdmin(firstAdmin);
        onlineStore.setBooks(books);
        onlineStore.setCustomers(customers);

        BookService bookService = new BookServiceImpl();
        LOGGER.info(bookService.getAll());
    }
}
