package com.store.definition;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/* Product 클래스 : 생성자 */
public class Product implements Serializable {

    /*
    * number : 상품 번호
    * name : 상품명
    * price : 상품 가격
    * stock : 상품 재고
    * endDay : 유통기한
    * */
    protected int number;
    protected String name;
    protected int price;
    protected int stock;
    protected LocalDate endDay;

    /* 기본 생성자 */
    public Product() { }

    /* Product 클래스 : 생성자 */
    public Product(int number, String name, int price, int stock, LocalDate endDay) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.endDay = endDay;
    }

    /* ======= getter / setter ======= */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return number == product.number && price == product.price && stock == product.stock && Objects.equals(name, product.name) && Objects.equals(endDay, product.endDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, price, stock, endDay);
    }

    @Override
    public String toString() {
        return "Product{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", endDay=" + endDay +
                '}';
    }
}
