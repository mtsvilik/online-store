package com.solvd.onlinestore;

import com.solvd.onlinestore.domain.onlinestore.Admin;
import com.solvd.onlinestore.service.AdminService;
import com.solvd.onlinestore.service.impl.AdminServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;

public class AdminTest {

    private static final AdminService ADMIN_SERVICE = new AdminServiceImpl();

    @BeforeClass
    public void setupBeforeClass() {
        System.out.println("This message will be before AdminTest class");
    }

    @BeforeTest
    public void setupBeforeTest() {
        System.out.println("This message will be before test");
    }

    @BeforeMethod
    public void setupBeforeMethods() {
        System.out.println("This method will run before each test method");
    }

    @Test(testName = "Check that admin's first name is not null")
    public void checkAdminFirstNameIsNotNullTest() {
        Admin admin = new Admin();
        admin.setFirstName("Ric");
        admin.setLastName("Ricardo");
        admin.setSalary(BigDecimal.valueOf(3000));

        admin = ADMIN_SERVICE.create(admin);
        Assert.assertNotNull(admin.getFirstName(), "Admin's first name is null");
    }

    @Test(testName = "Check that admin's last name is not null")
    public void checkAdminLastNameIsNotNullTest() {
        Admin admin = new Admin();
        admin.setFirstName("Anton");
        admin.setLastName("Antonov");
        admin.setSalary(BigDecimal.valueOf(2000));

        admin = ADMIN_SERVICE.create(admin);
        Assert.assertNotNull(admin.getLastName(), "Admin's last name is null");
    }

    @Test(testName = "Check that admin's salary is not null")
    public void checkAdminSalaryIsNotNullTest() {
        Admin admin = new Admin();
        admin.setFirstName("Anton");
        admin.setLastName("Antonov");
        admin.setSalary(BigDecimal.valueOf(2000));

        admin = ADMIN_SERVICE.create(admin);
        Assert.assertNotNull(admin.getSalary(), "Admin's salary is null");
    }

    @Test(testName = "Verify that the admin exists")
    public void verifyAdminGetByLastName() {
        Admin admin = ADMIN_SERVICE.getByLastName("Denisov");

        Assert.assertNotNull(admin);
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("This method will run after all test methods in AdminTest class");
    }

    @AfterTest
    public void setupAfterTest() {
        System.out.println("This message will be after test");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("This method will run after each test method");
    }
}
