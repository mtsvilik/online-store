package com.solvd.onlinestore;

import com.solvd.onlinestore.domain.author.Author;
import com.solvd.onlinestore.domain.author.Country;
import com.solvd.onlinestore.domain.book.Book;
import com.solvd.onlinestore.domain.book.PublishingHouse;
import com.solvd.onlinestore.domain.book.Sale;
import com.solvd.onlinestore.domain.customer.*;
import com.solvd.onlinestore.domain.onlinestore.Admin;
import com.solvd.onlinestore.domain.onlinestore.OnlineStore;
import com.solvd.onlinestore.domain.onlinestore.ShoppingCart;
import com.solvd.onlinestore.domain.paymentmethod.Card;
import com.solvd.onlinestore.domain.paymentmethod.PayPal;
import com.solvd.onlinestore.domain.paymentmethod.PaymentMethodDecorator;
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
        firstBook.setName("The thorn birds");
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
        firstCustomer.setFirstName("Nikita");
        firstCustomer.setLastName("Nikitin");
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

        /*
         *Factory pattern is used to divide customers into categories.
         */
        Customer customer = CustomerFactory.getCustomer(CustomerType.REGULAR_CUSTOMER);
        customer.setFirstName("Ivan");
        customer.setLastName("Ivanov");

        /*
         *The builder pattern is used to create an immutable admin.
         */
        Admin admin = Admin.builder()
                .id(1L)
                .firstName("Marina")
                .lastName("Marinina")
                .salary(BigDecimal.valueOf(1200))
                .build();

        /*
         *We can also use the builder to create mutable objects,
         *to increase the readability of the place where we fill in the object.
         */
        admin.toBuilder()
                .firstName("Olga")
                .build();
        /*
         *Using the facade pattern, we encapsulated the entire complexity of the method and
         * see only a "beautiful cover" of the method of buying a book in an online store.
         */
        firstBook.buyBook();

        /*
         *We have two methods to pay for purchases in the online store. Using the decorator pattern,
         *we can choose any payment method that is convenient for us
         */
        PaymentMethodDecorator paymentMethod = new PaymentMethodDecorator();
        paymentMethod.payWithCard();

        /*
         *Using the strategy pattern, we can choose any payment method that is convenient for us
         */
        firstCustomer.setPayment(new PayPal());
        firstCustomer.getPayment().pay();

        firstCustomer.setPayment(new Card());
        firstCustomer.getPayment().pay();

        /*
         *Using the listener pattern, the customer of the online store can subscribe to the newsletter of notifications,
         *receive notifications, unsubscribe from the newsletter
         */
        EventHolder.subscribe(EventType.SUBSCRIPTION, firstCustomer);
        EventHolder.subscribe(EventType.SUBSCRIPTION, secondCustomer);
        EventHolder.notify(EventType.SUBSCRIPTION);
        EventHolder.unsubscribe(EventType.NO_SUBSCRIPTION, firstCustomer);
    }
}
