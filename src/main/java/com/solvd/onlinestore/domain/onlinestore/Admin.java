package com.solvd.onlinestore.domain.onlinestore;

import java.math.BigDecimal;

public class Admin {

    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public static AdminBuilder builder() {
        return new AdminBuilder(new Admin());
    }

    public AdminBuilder toBuilder(){
        return new AdminBuilder(this);
    }

    public static class AdminBuilder {

        private final Admin admin;

        public AdminBuilder(Admin admin) {
            this.admin = admin;
        }

        public AdminBuilder id(Long id) {
            this.admin.id = id;
            return this;
        }

        public AdminBuilder firstName(String firstName) {
            this.admin.firstName = firstName;
            return this;
        }

        public AdminBuilder lastName(String lastName) {
            this.admin.lastName = lastName;
            return this;
        }

        public AdminBuilder salary(BigDecimal salary) {
            this.admin.salary = salary;
            return this;
        }

        public Admin build() {
            return admin;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
