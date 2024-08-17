package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Snack extends Product {
    public Snack(int number, String name, int price, int stock, LocalDate endDay) {
        super(number, name, price, stock, endDay);
    }

    public void eatSound() {
        System.out.println("바삭 바삭");
    }

    @Override
    public String toString() {
        return "Snack{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", endDay=" + endDay +
                '}';
    }
}
