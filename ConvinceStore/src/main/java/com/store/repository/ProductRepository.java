package com.store.repository;

import com.store.definition.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ProductRepository {
    private final ArrayList<Product> productList = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/store/db/productDB.dat";

    public ProductRepository() {
        File file = new File(FILE_PATH);

        if(!file.exists()) {
            ArrayList<Product> product = new ArrayList<>();
            product.add(new Snack(1, "포카칩", 1700, 10, LocalDate.of(2024, 10, 20)));
            product.add(new Snack(2, "포스틱", 1700, 10, LocalDate.of(2024, 11, 20)));
            product.add(new Drink(1, "허쉬초콜릿드링크", 1400, 10, LocalDate.of(2025, 3, 25)));
            product.add(new Drink(2, "코카콜라", 2000, 10, LocalDate.of(2025, 4, 27)));
            product.add(new Meal(1, "삼각김밥", 1200, 4, LocalDate.of(2024, 8, 20)));
            product.add(new Meal(2, "소시지", 1200, 4, LocalDate.of(2024, 9, 25)));
            product.add(new Medicine(1, "박카스", 1300, 10, LocalDate.of(2024, 10, 20)));
        }
    }

    private void saveProduct(File file, ArrayList<Product> products) {

    }

    private void loadProduct(File file) {

    }

}
