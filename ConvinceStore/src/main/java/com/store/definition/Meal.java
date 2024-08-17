package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Meal extends Product {

    public Meal(int number, String name, int price, int stock, LocalDate endDay) {
        super(number, name, price, stock, endDay);
    }

    @Override
    public void eatSound() {
        System.out.println("냠냠");
    }

    @Override
    public String toString() {
        return "Meal{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", endDay=" + endDay +
                '}';
    }
}
