package com.solvd.onlinestore;

import com.solvd.onlinestore.domain.book.Book;
import com.solvd.onlinestore.domain.book.Sale;
import com.solvd.onlinestore.service.BookService;
import com.solvd.onlinestore.service.impl.BookServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class BookTest {

    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    @BeforeClass
    public void setupBeforeClass() {
        System.out.println("This message will be before BookTest class");
    }

    @BeforeMethod
    public void setupBeforeMethods() {
        System.out.println("This method will run before each test method");
    }

    @DataProvider(name = "checkBooksId")
    public Object[][] checkBooksId() {
        return new Object[][]{
                {1L},
                {2L},
                {3L}
        };
    }

    @DataProvider(name = "deleteBooksId")
    public Object[][] deleteBooksId() {
        return new Object[][]{
                {4L},
                {6L},
                {8L},
                {10L}
        };
    }

    @Test(testName = "Check that book's price is not null")
    public void checkBookPriceIsNotNullTest() {
        Book book = new Book();
        book.setName("The outsider");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGenre(Book.Genre.FICTION);
        book.setBestseller(Book.Bestseller.MONTH);
        book.setSale(Sale.TWENTY_PERCENT);

        book = BOOK_SERVICE.create(1L, 1L, book);
        Assert.assertNotNull(book.getPrice(), "Book price is null");
    }

    @Test(testName = "Check that each book has a unique name")
    public void checkBookHasUniqueNameTest() {
        List<Book> books = BOOK_SERVICE.getAll();

        Assert.assertNotEquals(books.get(0).getName(), books.get(1).getName());
    }

    @Test(testName = "Check that book's name is not null", dataProvider = "checkBooksId")
    public void checkBooksNameIsNotNullTest(Long id) {
        List<Book> books = BOOK_SERVICE.getById(id);

        SoftAssert softAssert = new SoftAssert();
        books.forEach(book -> softAssert.assertNotNull(book.getName(), "Book name is null" + book.getId()));
    }

    @Test(testName = "Verify that book delete", dataProvider = "deleteBooksId")
    public void verifyDeleteBookTest(Long id) {
        BOOK_SERVICE.delete(id);
        List<Book> books = BOOK_SERVICE.getById(id);

        SoftAssert softAssert = new SoftAssert();
        books.forEach(book -> {
            softAssert.assertNull(book, "Book with id wasn't delete" + book.getId());
        });
        softAssert.assertAll();
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("This method will run after all test methods in BookTest class");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("This method will run after each test method");
    }
}
