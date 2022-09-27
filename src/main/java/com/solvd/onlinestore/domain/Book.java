package com.solvd.onlinestore.domain;

import java.math.BigDecimal;

public class Book {

    private Long id;
    private String name;
    private Author author;
    private Genre genre;
    private Bestseller bestseller;
    private Sale sale;
    private PublishingHouse publishingHouse;
    private BigDecimal price;

    public enum Bestseller {
        FOR_ALL_TIMES, YEAR, MONTH, WEEK
    }

    public enum Genre {
        FICTION, SCIENCE_FICTION, PSYCHOLOGY, EDUCATION, BUSINESS
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Bestseller getBestseller() {
        return bestseller;
    }

    public void setBestseller(Bestseller bestseller) {
        this.bestseller = bestseller;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", bestseller=" + bestseller +
                ", sale=" + sale +
                ", publishingHouse=" + publishingHouse +
                ", price=" + price +
                '}';
    }
}
