package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Medicine extends Product {

    public Medicine(int number, String name, int price, int stock, LocalDate endDay) {
        super(number, name, price, stock, endDay);
    }

    @Override
    public void eatSound() {
        System.out.println("으익 쓰다");
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", endDay=" + endDay +
                '}';
    }
}
