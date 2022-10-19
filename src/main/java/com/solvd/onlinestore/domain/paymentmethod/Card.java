package com.solvd.onlinestore.domain.paymentmethod;

import java.time.LocalDate;

public class Card implements IPay {

    private Long id;
    private String name;
    private Integer number;
    private LocalDate validityPeriod;

    @Override
    public void pay() {
        System.out.println("Your payment was successful, thank you for choosing card");
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(LocalDate validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", validityPeriod=" + validityPeriod +
                '}';
    }
}
