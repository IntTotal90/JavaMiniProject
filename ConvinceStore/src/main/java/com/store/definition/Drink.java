package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Drink extends Product {

    /* Drink 클래스 : 생성자 */
    public Drink(int number, String name, int price, int stock, LocalDate endDay) {
        /* 부모생성자 호출 */
        super(number, name, price, stock, endDay);
    }

    /* Drink : 먹는 행위 메소드 */
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
