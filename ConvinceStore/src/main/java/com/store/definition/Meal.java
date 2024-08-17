package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Meal extends Product {

    /* Meal 클래스 : 생성자 */
    public Meal(int number, String name, int price, int stock, LocalDate endDay) {
        /* 부모생성자 호출 */
        super(number, name, price, stock, endDay);
    }

    /* Meal 클래스 : 생성자 */
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
