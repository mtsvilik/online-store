package com.solvd.onlinestore;

import com.solvd.onlinestore.domain.book.PublishingHouse;
import com.solvd.onlinestore.service.PublishingHouseService;
import com.solvd.onlinestore.service.impl.PublishingHouseServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;

public class PublishingHouseTest {

    private static final PublishingHouseService PUBLISHING_HOUSE_SERVICE = new PublishingHouseServiceImpl();

    @BeforeClass
    public void setupBeforeClass() {
        System.out.println("This message will be before PublishingHouseTest class");
    }

    @BeforeMethod
    public void setupBeforeMethods() {
        System.out.println("This method will run before each test method");
    }

    @Test(testName = "Check that publishing house's name is not null")
    public void checkPublishingHouseNameIsNotNullTest() {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName("LABIRINT");

        publishingHouse = PUBLISHING_HOUSE_SERVICE.create(publishingHouse);
        Assert.assertNotNull(publishingHouse.getName(), "Publishing house's name is null");
    }

    @Test(testName = "Check that the publishing house exist")
    public void checkPublishingHouseGetByNameTest() {
        PublishingHouse publishingHouse = PUBLISHING_HOUSE_SERVICE.getByName("S&P Global");

        Assert.assertNotNull(publishingHouse);
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("This method will run after all test methods in PublishingHouseTest class");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("This method will run after each test method");
    }
}
