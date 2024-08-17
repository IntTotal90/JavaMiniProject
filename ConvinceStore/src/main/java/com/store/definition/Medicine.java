package com.store.definition;

import java.time.LocalDate;
import java.util.Date;

public class Medicine extends Product {

    /* Medicine 클래스 : 생성자 */
    public Medicine(int number, String name, int price, int stock, LocalDate endDay) {
        /* 부모생성자 호출 */
        super(number, name, price, stock, endDay);
    }

    /* Medicine 클래스 : 생성자 */
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
