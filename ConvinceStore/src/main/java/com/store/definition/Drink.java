package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Drink extends Product {

    public Drink(int number, String name, int price, int stock, LocalDate endDay) {
        super(number, name, price, stock, endDay);
    }

    @Override
    public void eatSound() {
        System.out.println("꿀꺽 꿀꺽");
    }

    @Override
    public String toString() {
        return "Drink{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", endDay=" + endDay +
                '}';
    }
}
