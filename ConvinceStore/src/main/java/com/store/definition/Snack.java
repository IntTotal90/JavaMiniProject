package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

/* Snack 클래스 */
public class Snack extends Product {

    /* Snack 클래스 생성자*/
    public Snack(int number, String name, int price, int stock, LocalDate endDay) {
        /* 부모생성자 호출 */
        super(number, name, price, stock, endDay);
    }

    /* Snack 클래스 먹는 소리 */
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
