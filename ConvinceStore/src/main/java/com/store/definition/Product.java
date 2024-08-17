package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public abstract class Product {
    protected int number;
    protected String name;
    protected int price;
    protected int stock;
    protected LocalDate endDay;

    public Product() { }

    public Product(int number, String name, int price, int stock, LocalDate endDay) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.endDay = endDay;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public abstract void eatSound();
}
